package com.google.opensource.composecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        StatefulCounter()

        val tasks = remember { getWellnessTasks().toMutableStateList() }
//        val tasks = remember {
//            mutableStateListOf<WellnessTask>().apply {
//                addAll(getWellnessTasks())
//            }
//        }

        WellnessTaskList(
            tasks = tasks,
            onCloseTask = { item -> tasks.remove(item) }
        )
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
