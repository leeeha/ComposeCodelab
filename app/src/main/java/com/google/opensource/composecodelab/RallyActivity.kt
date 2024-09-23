/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.opensource.composecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.google.opensource.composecodelab.ui.components.RallyTabRow
import com.google.opensource.composecodelab.ui.theme.RallyTheme
import timber.log.Timber

/**
 * This Activity recreates part of the Rally Material Study from
 * https://material.io/design/material-studies/rally.html
 */
class RallyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        setContent {
            RallyApp()
        }
    }
}

@Composable
fun RallyApp() {
    RallyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        // 백 스택에서 현재 선택된 탭 확인 (초기에는 OVERVIEW)
        var currentScreen = RallyTab.entries.find { tab ->
            currentDestination?.hasRoute(tab.route) == true
        } ?: RallyTab.OVERVIEW

        // 상세 화면으로 진입한 경우, 상단 탭 구분
        if (currentDestination?.hasRoute(SingleAccount::class) == true) {
            currentBackStack?.toRoute<SingleAccount>()?.let { account ->
                currentScreen = account.currentTab
            }
        }

        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = RallyTab.entries,
                    currentScreen = currentScreen,
                    onTabSelected = { destination ->
                        navController.navigateToRallyTab(destination)
                    },
                )
            }
        ) { innerPadding ->
            RallyNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
