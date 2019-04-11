
## Singleton

- 어떤 클래스의 인스턴스는 오직 하나임을 보장하며, 이 인스턴스에 접근할 수 있는 전역적인 접촉점을 제공하는 패턴
- 보내는 사람 이메일을 어디서든 관리하기 쉽게 처리하기 위해 Singleton 적용

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day19/images/2.png" width="40%"></img>|<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day19/images/3.png" width="40%"></img>

## Final Project

- firebase cloud messaing 적용
   - final project fcm 등록
   - cloud messaging test 
  
- 회원가입 시, token 값 외부 DB에 저장
    - SignUp.jsp와 JoinActivity.java 수정
    - 회원가입 페이지 들어갈 시, getToken()을 이용하여 토큰 값 저장 후, 서버에 전달

- 로그인한 회원의 이메일을 Singleton을 이용해 전역적으로 설정

- chatting activity, reclycerView 추가
    - recyclerView, adapter 적용하여 ChattingActivity 구현

- DB에 저장된 상대방 Token 값 가져와서 푸쉬 메세지 전송


<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day19/images/1.png" width="60%"></img>