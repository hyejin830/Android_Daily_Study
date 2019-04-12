## 브로드 캐스트 리시버
- 문자메시지 도착, 배터리 방전, SD카드 탈부착, 네트워크 환경 변경 등
- 특정 이벤트가 발생하면 보내는 방송 신호를 받아서 처리하는 것
- 이러한 특정 방송 신호는 안드로이드에서 제공해주기도 하지만 특정 신호를 본인이 만들어서 보낼 수도 있다.

### 1) 리시버 생성

```
BroadcastReceiver brodCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String actionState = intent.getAction();
            // 브로드캐스트리시버 상태 조건문 
        }
    };
```

### 2) 등록
- 등록은 onResume() 에서

```
IntentFilter broadCastApplyIntentFilter = new IntentFilter();
        broadCastApplyIntentFilter.addAction(Intent.상태변화);
        registerReceiver(brodCastReceiver, broadCastApplyIntentFilter);
```

### 3) 제거
- 제거는 onPause()

```
unregisterReceiver(brodCastReceiver);
```

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/1.png" width="40%">

#### telnet 활용하여 가상머신 설정

##### 1. 가상머신 접속	
- telnet localhost [가상머신 실행 포트]
- 가상머신 실행 포트는 일반적으로 5554부터 시작하며
- adb devices 명령어로 확인 가능

##### 2. 권한 확인

```
Android Console: Authentication required
Android Console: type 'auth <auth_token>' to authenticate
Android Console: you can find your <auth_token> in
'C:\Users\test.user-PC\.emulator_console_auth_token'
```
- 마지막 줄에 있는 파일을 메모장으로 열고 토큰 값 확인
- auth  [권한 토큰]	명령어를 이용하여 권한을 승인받는다.

##### 3. 배터리 관련 명령어

- power capacity  [숫자]
- power ac on
- power ac off


<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/2.png" width="40%">

```
power capacity 50
```

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/3.png" width="40%">


## 카메라

외부 라이브러리를 이용한 QR code 예제

```
implementation 'com.journeyapps:zxing-android-embedded:3.6.0'
```

- 가상머신은 실제 카메라 기능을 하지 못함

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/4.png" width="40%"> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/5.png" width="40%">


## APK 파일 배포하여 테스트

- APK Release

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/9.png" width="40%"> 

- apk로 카메라 기능 확인
  
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/6.png" width="40%"> 

- QR code 인터넷에서 생성

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/8.png" width="50%"> 

- 결과 

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day20/images/7.png" width="40%"> 

