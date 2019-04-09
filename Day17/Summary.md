
# sendNotification

## 1. Intent/Flag/Pending Intent
  ### 1.1 Android Task
태스크는 어플리케이션에서 실행되는 액티비티를 보관하고 관리하며 Stack형태의 연속된 액티비티로 구성

  ### 1.2 Intent Flag
인텐트를 사용할 때 플래그로 `인텐트의 속성`을 지정 가능

	- FLAG_ACTIVITY_CLEAR_TOP
	호출하는 액티비티가 스택에 존재할 경우에, 해당 액티비티를 최상위로 올리면서, 
	그 위에 존재하던 액티비티들은 모두 삭제를 하는 플래그
	예를 들어 ABCDE가 존재하는 상태에서 C를 호출하게 되면 ABC만 남고 DE는 제거

	- FLAG_ACTIVITY_FORWARD_RESULT
	startActivityForResult를 이용하여서 Activity를 호출할 경우에, 호출하는 쪽이 
	아닌 한번 더 거쳐서 Result를 받고 싶을 때 사용
	이러한 경우에 사용하면 되며, A->B->C 일 경우에 C에서 setResult를 설정하여주고, 
	B에서 finish를 하게 되면 A에서는 C의 값을 반환

	- FLAG_ACTIVITY_REORDER_TO_FRONT
	이 플래그를 이용하게 되면 호출하려는 Activity가 스택에 존재할 경우에
	최상위로 올려주는 효과
	예를 들어 ABCDE가 있을 경우 C를 호출하게 되면 ABDEC순서로 정렬

	- FLAG_ACTIVITY_SINGLE_TOP
	호출되는 Activity가 최상위에 존재할 경우에는 해당 Activity를 다시 생성하지 않고
	존재하던 Activity를 다시 사용
	예를 들면 ABC가 존재하는 경우에 C를 호출하게 되면 기존과 동일하게 ABC가 나옴

  ### 1.3 Pending Intent
직접 작업을 처리하지 않고 `다른 컴포넌트에 위임처리`를 하는 기능
	ex)알림 창을 클릭하면 알림창이 처리하지 않고 액티비티를 호출하여 처리하도록 하는 것

#### Pending Intent Flag
	 - FLAG_CANCEL_UPDATE
	 이전 생성된 것를 취소하고 새롭게 생성

	 - FLAG_UPDATE_CURRENT
	 이전 생성된 것이 있다면 변경

	 - FLAG_ONE_SHOT
	 일회용으로 생성 (위젯에 적용한다면 최초 클릭에만 작동하고 그 다음 클릭부터는 작동하지 않음)

	 - FLAG_NO_CREATE
	 생성된 것이 있다면 회수

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day17/images/1.png" width="40%"></img>|<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day17/images/2.png" width="40%"></img>
  

## 2. 커스터마이징

### 2.1 아이콘

```
.setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.이미지파일이름))
.setSmallIcon(android.R.drawable.이미지파일이름)
```

### 2.2 알림음 

```
Uri soundUri = Uri.parse(
                "android.resource://" +
                        getApplicationContext().getPackageName() +
                        "/raw/" +
                        R.raw.음원파일이름);

```

### 2.3 설정

```
NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channel_id)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_info))
                .setSmallIcon(android.R.drawable.ic_dialog_info)  // 알림 아이콘
                .setContentTitle(title)                           // 알림 타이틀
                .setContentText(message)                          // 알림 메세지
                .setAutoCancel(true)                
                .setSound(soundUri)                               // 알림음
                .setContentIntent(pendingIntent);
```


프로젝트에 사용한 

음원 출처 : 
http://www.orangefreesounds.com/gentle-wake-alarm-clock/

이미지 출처 :
https://material.io/tools/icons/?search=message&icon=message&style=baseline


## 3 서버를 이용한 메세지 PUSH

### 3.1 library 추가

```
com.fasterxml.jackson.databind.jar
```

### 3.2 메세지 보낼 jsp 추가

토큰값과 메시지 타이틀 및 메세지 설정

```
"{\"to\":\"토큰값\",\"notification\":{\"title\":\"Portugal vs. Denmark\",\"body\":\"great match!\"}}";
```

### 3.3 실습 

- 비동기 TASk VM [코드](https://github.com/hyejin830/Android_Daily_Study/tree/master/Day17/Lesson_17_04009/app/src/main/java/com/example/lesson_17_04009/practice01_notification)

- PUSH 받는 VM [코드](https://github.com/hyejin830/Android_Daily_Study/tree/master/Day16/PassiveFireBaseExample/app/src/main/java/com/example/passivefirebaseexample/passive_practice01_firebase)

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day17/images/3.png" width="40%"></img>