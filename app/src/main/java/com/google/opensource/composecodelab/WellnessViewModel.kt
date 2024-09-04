package com.google.opensource.composecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

/**
 * mutableStateOf() -> MutableState<T>
 * mutableStateListOf(), toMutableStateList() -> SnapshotStateList<T>
 *
 * UI 로직: 화면에 State 변경을 표시하는 방법 (화면 네비게이션, 스낵바 표시 등)
 * 비즈니스 로직: 상태 변경 시 실행할 작업 (결제하기, 사용자 환경설정, 네트워크 요청 등)
 * */
class WellnessViewModel: ViewModel() {
    private var _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

    fun remove(item: WellnessTask){
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean){
        _tasks.find{ it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}
