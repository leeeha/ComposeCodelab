package com.google.opensource.composecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    tasks: List<WellnessTask> = remember {
        getWellnessTasks()
    }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(tasks) { task ->
            StatefulWellnessTaskItem(
                taskName = task.label
            )
        }
    }
}

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
