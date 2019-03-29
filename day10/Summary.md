## Intent

### 암시적 인텐트 (Implicit Intent)
특정 액션을 지정하여 안드로이드에서 제공하는 기존 응용 프로그램을 실행
암시적 인텐트는 보통 액션과 데이터를 지정해야 한다.
액션은 어떤 행동을 할 것인가를 지정 
ex) 전화, 지도, 화면에 보이기, 웹, 이메일 등

#### 대표적인 액션

`ACTION_VIEW` 
http : 브라우저
tel : 다이얼러
geo : 구글 맵

`ACTION_SEND`
다른 앱을 통해 공유할 수 있는 데이터를 보낼 때
이메일, SNS 공유 등

`ACTION_EDIT`
다른 앱을 통해 특정 데이터를 수정할 때
연락처 변경 등

#### 데이터 전달
URI 객체를 통해 전달

`예시`
```
    Uri uriMakeCall = Uri.parse("tel:010-0000-0000");
```

#### 전화 권한 설정 (CALL_PHONE)

```
    <uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>
```

- 이미지 첨부하기

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/1.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/2.png" width="20%"></img> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/3.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/4.png" width="20%"></img>

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/5.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/6.png" width="20%"></img> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/7.png" width="20%"></img>

 [코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/Lesson_10_0329/app/src/main/java/com/example/lesson_10_0329/example01_implicit_intent/ImplicitIntentExampleActivity.java)

## 외부 라이브러리 이용하기 API Use 

### 1 build.gradle 라이브러리 추가

gradle이란
빌드 배포 도구, 이클립스의 라이브러리 관리와 비슷한 역할 수행

버전 맞춰서 작성 유의

```
    implementation 'com.android.support:design:28.0.0'
```

### 2 menu resource 작성

```
 <menu xmlns:android="http://schemas.android.com/apk/res/android">
     <item android:id="@+id/action_search"
          android:title="@string/menu_search"
          android:icon="@drawable/ic_search" />
     <item android:id="@+id/action_settings"
          android:title="@string/menu_settings"
          android:icon="@drawable/ic_add" />
     <item android:id="@+id/action_navigation"
          android:title="@string/menu_navigation"
          android:icon="@drawable/ic_action_navigation_menu" />
 </menu>
```

### 3 xml 작성

```
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

  <!-- Main content -->

  <android.support.design.widget.BottomNavigationView
      android:id="@+id/bottom_navigation"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_gravity="bottom"
      android:background="@color/colorPrimary"
      app:itemIconTint="@color/white"
      app:itemTextColor="@color/white"
      app:menu="@menu/bottom_navigation_menu" />

</FrameLayout>

```

출처 : https://developer.android.com/reference/android/support/design/widget/BottomNavigationView

#### 예제

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/images/8.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/day10/Lesson_10_0329/app/src/main/java/com/example/lesson_10_0329/example02_api_use/ApiUseExampleActivity.java)

아이콘 출처 : https://material.io/tools/icons/?style=baseline

