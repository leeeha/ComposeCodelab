package com.google.opensource.composecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * State에 따라 UI에 표시되는 항목이 결정된다.
 * 상태는 존재하고, 이벤트는 발생한다.
 *
 * Composition: Composable 실행에 따라 Compose가 빌드한 UI
 * Recomposition: 이벤트 발생에 따라 변경된 State를 UI에 반영하기 위해 Composable을 다시 실행하는 것
 *
 * remember: 리컴포지션이 발생해도 상태가 보존되도록 함. (컴포지션에 private 객체를 저장하는 것과 유사)
 * rememberSavable: 스크롤에 따른 컴포지션 종료 및 재생성, 액티비티 또는 프로세스 재생성에도 상태 유지
 * */
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableIntStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = { count++ },
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10,
        ) {
            Text("Add one")
        }
    }
}

/**
 * --- State hoisting의 중요한 속성
 * 단일 소스 저장소: 상태를 복제하는 대신 컴포저블의 호출자로 위치를 끌어올리기 때문에 소스 저장소가 하나만 있다. (버그 방지에 도움)
 * 공유 가능: 끌어올린 상태를 여러 컴포저블과 공유할 수 있다.
 * 가로채기 가능: Stateless 컴포저블의 호출자는 상태를 변경하기 전에 이벤트를 무시할지 수정할지 결정할 수 있다.
 * 분리 가능: Stateless 컴포저블의 상태는 어디에든(예: ViewModel) 저장할 수 있다.
 *
 * --- 상태 호이스팅의 일반적인 패턴
 * value: T - 표시할 현재 값
 * onValueChange: (T) -> Unit - 새로운 값 T로 상태가 변경되도록 요청하는 이벤트
 * */
@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text("Add one")
        }
    }
}

/**
 * State를 어느 위치로 끌어올려야 하는가?
 *
 * 상태는 '적어도' 그 상태를 사용하는 모든 컴포저블의 '가장 낮은 공통 상위 요소'로 끌어올려야 합니다. (get)
 * 상태는 '최소한' 변경될 수 있는 '가장 높은 수준'으로 끌어올려야 합니다. (set)
 * 두 상태가 동일한 이벤트에 대한 응답으로 변경되는 경우 두 상태는 동일한 수준으로 끌어올려야 합니다.
 *
 * 충분히 높은 수준으로 상태를 끌어올리지 않으면, UDF를 따르기 어려울 수 있다.
 * */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}