# 학습 키워드

- NavGraph
  - 앱 내의 모든 네비게이션 destination과 이들이 서로 연결되는 방식을 정의하는 데이터 구조
- NavController
  - 목적지 간 탐색을 관리하기 위한 중앙 코디네이터
  - 목적지 간 탐색, 딥 링크 처리, 백 스택 관리 등을 위한 메서드 제공
  - rememberNavController(), navigate(), currentBackStackEntryAsState() 
  - 항상 하나의 NavHost와 연결되어야 한다.
- NavHost
  - 탐색 가능한 destination의 모음
  - NavGraph를 구성하는 destination 저장하고, 화면에 표시하는 컨테이너 역할
  - 여러 destination을 탐색할 때, NavHost는 자동으로 recomposition 된다.
  - NavGraph와 NavController를 연결하는 역할
- Route 
  - destination과 이에 필요한 모든 데이터를 고유하게 식별하는 경로
  - 경로를 이용해 destination 탐색 가능 
- [Type Safe Navigation](https://medium.com/androiddevelopers/navigation-compose-meet-type-safety-e081fb3cf2f8)

# 데모 비디오 

https://github.com/user-attachments/assets/90c2232b-8cac-4a8a-bbdf-62bbb7b0e256
