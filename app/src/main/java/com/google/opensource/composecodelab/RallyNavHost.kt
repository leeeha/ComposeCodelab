package com.google.opensource.composecodelab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navOptions
import androidx.navigation.toRoute
import com.google.opensource.composecodelab.ui.accounts.AccountsScreen
import com.google.opensource.composecodelab.ui.accounts.SingleAccountScreen
import com.google.opensource.composecodelab.ui.bills.BillsScreen
import com.google.opensource.composecodelab.ui.overview.OverviewScreen

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Overview,
        modifier = modifier
    ) {
        composable<Overview> {
            OverviewScreen(
                onClickSeeAllAccounts = {
                    navController.navigateToRallyTab(RallyTab.ACCOUNTS)
                },
                onClickSeeAllBills = {
                    navController.navigateToRallyTab(RallyTab.BILLS)
                },
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(
                        currentTab = RallyTab.OVERVIEW,
                        accountType = accountType
                    )
                }
            )
        }
        composable<Accounts> {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(
                        currentTab = RallyTab.ACCOUNTS,
                        accountType = accountType
                    )
                }
            )
        }
        composable<Bills> {
            BillsScreen()
        }
        composable<SingleAccount>(
            deepLinks = listOf(
                navDeepLink<SingleAccount>(
                    basePath = DEEP_LINK_SINGLE_ACCOUNT_BASE_PATH
                )
            )
        ) { navBackStackEntry ->
            val account = navBackStackEntry.toRoute<SingleAccount>()
            SingleAccountScreen(account.accountType)
        }
    }
}

fun NavController.navigateToRallyTab(destination: RallyTab) {
    val tabNavOptions = navOptions {
        popUpTo(
            this@navigateToRallyTab.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when (destination) {
        RallyTab.OVERVIEW -> navigateToOverview(navOptions = tabNavOptions)
        RallyTab.ACCOUNTS -> navigateToAccounts(navOptions = tabNavOptions)
        RallyTab.BILLS -> navigateToBills(navOptions = tabNavOptions)
    }
}

fun NavController.navigateToOverview(navOptions: NavOptions) =
    navigate(route = Overview, navOptions)

fun NavController.navigateToAccounts(navOptions: NavOptions) =
    navigate(route = Accounts, navOptions)

fun NavController.navigateToBills(navOptions: NavOptions) =
    navigate(route = Bills, navOptions)

fun NavController.navigateToSingleAccount(
    currentTab: RallyTab,
    accountType: String,
    navOptions: NavOptions? = null,
) {
    navigate(
        route = SingleAccount(
            currentTab = currentTab,
            accountType = accountType
        ),
        navOptions = navOptions
    )
}
