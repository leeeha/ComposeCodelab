package com.google.opensource.composecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * mutableStateOf() -> MutableState<T>
*  mutableStateListOf(), toMutableStateList() -> SnapshotStateList<T>
 * */
@Composable
fun WellnessTaskList(
    tasks: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = tasks,
            key = { item -> item.id }
        ) { task ->
            StatefulWellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) }
            )
        }
    }
}
