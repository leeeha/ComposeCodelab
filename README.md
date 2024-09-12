# 학습 키워드 

## State, Event

- State에 따라 UI에 표시되는 항목이 결정된다.
- 상태는 존재하고 이벤트는 발생한다.

<img width="200" src="https://github.com/user-attachments/assets/c8693df0-5132-42dc-afd2-6008738d16af"/>
<img height="200" src="https://github.com/user-attachments/assets/405d77cf-4dbe-48aa-bc5c-6cf4f17828c0"/>

## Recomposition

- Composition: Composable 실행에 따라 Compose가 빌드한 UI
- Recomposition: 이벤트 발생에 따라 변경된 State를 UI에 반영하기 위해 Composable을 다시 실행하는 것

<img height="200" src="https://github.com/user-attachments/assets/b53dfeee-23f3-49f4-bb26-fe0415a444bd"/>

## 상태 보존

- remember: 리컴포지션이 발생해도 상태가 보존되도록 함. (컴포지션에 private 객체를 저장하는 것과 유사)
- rememberSaveable: 스크롤에 따른 컴포지션 종료 및 재생성, 액티비티 또는 프로세스 재생성 같은 상황에도 상태 보존

## State hoisting

### 끌어올린 상태가 갖는 중요한 속성
* 단일 소스 저장소: 상태를 복제하는 대신 컴포저블의 호출자로 위치를 끌어올리기 때문에 소스 저장소가 하나만 있다. (버그 방지에 도움)
* 공유 가능: 끌어올린 상태를 여러 컴포저블과 공유할 수 있다.
* 가로채기 가능: Stateless 컴포저블의 호출자는 상태를 변경하기 전에 이벤트를 무시할지 수정할지 결정할 수 있다.
* 분리 가능: Stateless 컴포저블의 상태는 어디에든(예: ViewModel) 저장할 수 있다.

### 상태 호이스팅의 일반적인 패턴
* value: T - 표시할 현재 값
* onValueChange: (T) -> Unit - 새로운 값 T로 상태가 변경되도록 요청하는 이벤트

### State를 어느 위치로 끌어올려야 하는가?

* 상태는 **적어도** 그 상태를 사용하는 모든 컴포저블의 **가장 낮은 공통 상위 요소**로 끌어올려야 한다. (get)
* 상태는 **최소한** 변경될 수 있는 **가장 높은 수준으로** 끌어올려야 한다. (set)
* 두 상태가 동일한 이벤트에 대한 응답으로 변경되는 경우 두 상태는 동일한 수준으로 끌어올려야 한다.
* 충분히 높은 수준으로 상태를 끌어올리지 않으면, UDF를 따르기 어려울 수 있다.

## ViewModel의 State

* mutableStateOf() -> MutableState<T>
* mutableStateListOf(), toMutableStateList() -> SnapshotStateList<T>
* UI 로직: 화면에 State 변경을 표시하는 방법 (화면 네비게이션, 스낵바 표시 등)
* 비즈니스 로직: 상태 변경 시 실행할 작업 (결제하기, 사용자 환경설정, 네트워크 요청 등)

# 데모 비디오

https://github.com/user-attachments/assets/81c85128-08f4-4b49-8bd3-9228ce231f92

