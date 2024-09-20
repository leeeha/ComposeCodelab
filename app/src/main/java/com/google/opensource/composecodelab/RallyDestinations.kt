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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

/**
 * Rally Destination routing
 * */
@Serializable
data object Overview

@Serializable
data object Accounts

@Serializable
data object Bills

@Serializable
data class SingleAccount(val type: String)
const val DEEP_LINK_SINGLE_ACCOUNT_BASE_PATH = "rally://single_account"

/**
 * Rally Tab enum class
 * */
enum class RallyTab(
    val icon: ImageVector,
    val route: KClass<*>
) {
    OVERVIEW(
        icon = Icons.Filled.PieChart,
        route = Overview::class
    ),
    ACCOUNTS(
        icon = Icons.Filled.AttachMoney,
        route = Accounts::class
    ),
    BILLS(
        icon = Icons.Filled.MoneyOff,
        route = Bills::class
    )
}
