
## 서비스

- 화면 없이 백그라운드에서 동작하는 프로그램
- 백그라운드 프로세스라고도 함
- 액티비티는 화면이 종료되면 동작하지 않지만 서비스는 백그라운드에서 화면과 상관없이 계속 동작함

### 예제

- 서비스 동작을 하는지만 확인

UI

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/0.png" width="20%"></img>

Log

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/1.png" width="60%"></img>|
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/1.png" width="60%"></img>


## 푸시 알림 구현

### 1) FCM 설정
- 프로젝트 생성
 https://console.firebase.google.com/?hl=ko	에 접속해서 구글 ID로 로그인하고 프로젝트 생성

### 2) 안드로이드 스튜디오
    
#### (1) Firebase에 앱 등록 (수동)
 - Firebase 콘솔에서 안드로이드 모양 클릭

 - Android 패키지 이름 : 패키지이름 입력
		
 - 앱 닉네임(선택사항) : 마음대로

 - 앱 등록 클릭

 - google-services.json 파일 다운

 - google-services.json 파일을 안드로이드 스튜디오의 프로젝트의 app 밑에 복사

 - 프로젝트 안의 build.gradle 파일 수정

```
dependencies {
	        classpath 'com.google.gms:google-services:4.0.1'	// 추가
	    }
```

 - 프로젝트 안의 app 폴더 안의 build.gradle 파일 수정

```
dependencies {
	      implementation 'com.google.firebase:firebase-core:16.0.4'		// 추가
	      implementation 'com.google.firebase:firebase-messaging:17.3.4'	// 추가
	  }
	  apply plugin: 'com.google.gms.google-services'		// 추가
```
	  
안드로이드 스튜디오의 오른쪽 위에 sync now를 클릭

#### (2-1) 설치한 모든 앱에 메세지 보내기
 - 클라우드 메세징 이용
 - 성장 -> Cloud Messaging 이용

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/6.png" width="60%"></img>

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/7.png" width="20%"></img>


#### (2-2) 특정 핸드폰에 보내기
 - https://fcm.googleapis.com/fcm/send

```
curl -X POST -H "Authorization: key=[서버키]" -H "Content-Type: application/json" -d '{
    "to": "[토큰]",
    "data": {
        "title":"My Push Test",
        "message":"Test Message"
    }
}'
```
[서버키] : Firebase 콘솔에서 -> Project Overview 옆 톱니바퀴 -> 프로젝트 설정 -> 클라우드 메시징 -> 서버키 복사

[토큰] : 안드로이드 스튜디오에서 밑에 Logcat에서 token 검색 -> 어플을 실행 했을 때 token이 로그에 찍혀 나옴

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/3.png" width="50%"></img>|<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/4.png" width="50%"></img>

  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day16/images/5.png" width="20%"></img>