# 학습 키워드 

### collectAsStateWithLifecycle()

- ViewModel로부터 안전하게 Flow를 수집하는 방법 
- 앱이 백그라운드 상태로 전환되면 Flow 수집을 중단하여, 불필요한 리소스 낭비 방지 
- 다른 비동기 스트림의 경우: LiveData.observeAsState(), Observable.subscribeAsState()

### SideEffect

- Composable 함수의 범위 밖에서 발생하는 앱 상태에 대한 변경사항 
- 예시: 사용자가 버튼을 눌러서 새 화면이 열리는 경우, 앱이 인터넷에 연결되지 않았을 때 에러 메시지 표시 등 

### LaunchedEffect

- 컴포저블 내부에서 suspend 함수를 안전하게 실행하는 방법
- 컴포지션이 종료되면 코루틴도 취소되므로 리소스 낭비 방지
- 매개변수로 지정한 key 중에 하나가 변경되면, 기존 코루틴은 취소되고 새 코루틴에서 effect 재시작
- 컴포저블 수명주기 동안 한번만 effect 실행하려면, key를 상수 값으로 지정 (ex. Unit)

### rememberUpdatedState

- LaunchedEffect의 key 매개변수 중 하나가 변경되어도, effect를 다시 시작하고 싶지 않을 때는 
- rememberUpdatedState로 최신 값을 캡쳐해두고, 리컴포지션 발생 시 해당 값으로 갱신한다. 
- effect를 다시 생성하고 실행하는 데 비용이 많이 들거나, 수명이 긴 작업에 유용 (ex. 몇초 동안 랜딩 화면 표시)

### rememberCoroutineScope 

- 컴포저블 외부에서 컴포저블의 수명주기를 인식하는 CoroutineScope가 필요할 때 사용
- 컴포지션의 호출 지점에 바인딩 된 CoroutineScope를 반환하므로, 컴포지션이 종료되면 코루틴 스코프도 취소된다. 

### DisposableEffect 

- 키가 변경되거나 컴포지션이 종료될 때 정리해야 하는 작업이 있는 경우 사용 
- 예시: LifecycleEventObserver 사용해 생명주기 이벤트에 따라 cleanup 작업 수행 

### produceState

- compose state가 아닌 것을 compose state로 변환할 때 사용 
- collectAsStateWithLifecycle() API도 내부적으로 produceState 사용하고 있음. 

### derivedStateOf

- 다른 state에서 파생된 state를 만들고 싶을 때 사용 
- derivedStateOf 계산 블록은 내부 상태가 변경될 때마다 실행되지만, 컴포저블 자체는 계산 결과가 마지막 결과와 다를 때만 리컴포지션 된다.
- 과도한 리컴포지션의 발생을 방지하여 성능 최적화 

# 스크린샷 

<img width="250" src="https://github.com/user-attachments/assets/40c7abc5-ee36-4ed7-88cf-99079731e88c"/>

<img width="250" src="https://github.com/user-attachments/assets/139e7ac3-1816-464c-a340-e7e4c44a3634"/>

<img width="250" src="https://github.com/user-attachments/assets/e38006f0-dd21-46d3-b845-59a4d959d9f5"/>

<img width="250" src="https://github.com/user-attachments/assets/e9eb8e10-28f6-4a24-b29e-7984523520cf"/>