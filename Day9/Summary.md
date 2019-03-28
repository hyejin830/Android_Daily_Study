## 1. 4대 컴포넌트

### 1.1 컴포넌트란
소프트웨어 개발을 마치 레고블록을 쌓듯이 쉽게 할 수 있도록 하는 기술
즉, 기존의 코딩 방식에 의한 개발에서 벗어나 소프트웨어를 구성단위(module)로 미리 만든 뒤 필요한 응용 기술을 개발할 때 이 모듈을 조립하여 완성하는 기술

### 1.2.1 액티비티
화면을 구성하는 가장 기본적인 컴포넌트

API 주소 
https://developer.android.com/reference/android/app/Activity

#### 1.2.1.1 Context
어플리케이션에 관하여 시스템이 관리하고 있는 정보에 접근 또는 안드로이드 시스템 서비스에서 제공하는 API를 호출
getSystemService() Context내부 메소드

### 1.2.2 서비스
액티비티와 상관없이 백그라운드에서 동작하는 컴포넌트

### 1.2.3 브로드캐스트 리시버
문자 메세제 도착, 배터리 방전, SD 카드 탈부착, 네트워크 환경 변화 등이 발생했을 때 모든 응용 프로그램들이 인지할 수 있도록 신호를 보내는 컴포넌트

### 1.2.4 콘텐트 프로바이더
서로 다른 어플들끼리 데이터를 공유하기 위한 컴포넌트
데이터를 제공하는 방법으로 url사용
컴포넌트 간의 데이터 공유 시 Intent 사용

## 2. 새로운 액티비티 생성 : Intent 
```
    1. 새로운 액티비티에서 사용할 xml 파일 생성
    2. 새로운 액티비티가 될 Activity 클래스를 상속받는 java 파일 생성
    3. AndroidManifest.xml 파일에 새로운 액티비티 정보 추가
    4. 기존의 액티비티에서 인텐트를 전달하면서 새로운 액티비티를 호출
```
#### 2.1 예제

이전화면에서 다음화면으로 넘어가는 예제

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/1.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/2.png" width="20%"></img>

 >코드

 [이전화면](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/example01_intent/PrevIntentExampleActivity.java)

 [다음화면](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/example01_intent/NextIntentExampleActivity.java)

#### 2.2 실습

2개의 라디오 버튼과 1개의 버튼
버튼을 클릭하면 라디오 버튼에서 선택한 항목에 맞게 이동하기 구현

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/3.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/4.png" width="20%"></img>

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/5.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/6.png" width="20%"></img>

>코드

[첫 화면](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/practice01_intent/StartIntentPracticeActivity.java)

[첫번째 이동 화면](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/practice01_intent/FirstIntentPracticeActivity.java)

[두번째 이동 화면](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/practice01_intent/SecondIntentPracticeActivity.java)

## 3. 라이프사이클

### 3.1.1 onCreate()
액티비티가 처음 만들어질 때 호출되는 함수
어플리케이션이 `처음 시작할 때 최초로 한번 실행`되는 함수
주로 뷰를 만들거나 리소스를 불러오는 작업 담당
매개변수로 이전 상태의 정보를 담고있는 Bundle을 제공 (Bundle savedInstanceState)

### 3.1.2 onStart()
액티비티가 사용자에게 보여지기 직전에 호출되는 함수

### 3.1.3 onResume()
액티비티가 비로소 화면에 보여지는 단계
사용자에게 화면이 제공되었고 포커스가 잡힌 상태

### 3.1.4 onRestart()
액티비티가 멈춰있다가 다시 호출될 때 불리는 함수

### 3.1.5 onPause()
다른 액티비티가 호출 되는 경우 `현재 액티비티 위에 다른 액티비티가 올라와서 포커스를 잃었을 때` 호출되는 함수
다른 Activity가 호출되기 전에 실행되기 때문에 onPause()함수에서 시간이 많이 소요되는 작업이나, 많은 일을 처리하면 다른 액티비티가 실행되기까지 시간이 오래걸리기 때문에 이곳은 단순 데이터를 저장하는 용도로 사용

### 3.1.6 onStop()
액티비티 `위에 다른 액티비티가 완전히 올라와 화면에서 100% 가려질 때` 호출되는 함수
홈 키를 누르는 경우, 또는 다른 액티비티도 이동이 있는 경우 
만약 이 상태에서 Activity가 다시 불려지면, onRestart()함수가 호출됨

### 3.1.7 onDestroy()
액티비티가 `완전히 제거될 때 호출`되는 함수
finish() 메소드를 호출하거나, 시스템 메모리 확보를 위해 호출

#### 생명주기

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/7.png" width="20%"></img>

[출처]https://www.google.co.jp/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjP6rv01qPhAhXQFogKHb3bDpQQjRx6BAgBEAU&url=https%3A%2F%2Fdocs.microsoft.com%2Fko-kr%2Fxamarin%2Fandroid%2Fapp-fundamentals%2Factivity-lifecycle%2F&psig=AOvVaw0EJOPpXukIHk-u5WHfD0lq&ust=1553822734731594

### 3.2 예제

각 함수에 Log를 달아 어플리케이션의 포커스에 따른 함수 호출을 확인한다. 

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/8.png"></img>

 [코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/example02_lifecycle/LifeCycleExampleActivity.java)

## 4. 액티비티에 인텐트로 데이터 전달

### 4.1 명시적 인텐트
다른 액티비티의 이름을 `명확히 지정할 때` 사용하는 방법

데이터를 전달하는 액티비티
```
    intent.putExtra("메시지태그","전달 받을 메세지");
    startActivity(intent);
```

데이터를 받는 액티비티
```
    Intent intent = getIntent();
    String msg = Intent.getStringExtra("메세지태그");
```

### 4.1.1 예제

메세지태그를 통한 String 값 전달하여 다음 액티비티에 출력한다.

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/9.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/10.png" width="20%"></img>

>코드

 [데이터 보내는 액티비티](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/example03_intent_pass_on_data/PrevExplicitIntentActivity.java)

 [데이터 받는 액티비티](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/example03_intent_pass_on_data/NextExplicitIntentActivity.java)


 ### 4.2 startActivityForResult
 데이터를 받은 액티비티가 finish로 종료하고 이전 액티비티에게 다시 값을 넘겨줄 때 사용

 데이터를 전달하고 가공한 데이터를 다시 받는 액티비티

```
    intent.putExtra("메세지 태그","전달 값");
    startActivityForResult(intent,0);
```

 `onActivityResult` 메소드를 오버라이딩해줘야 한다.

```
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
        // 가공받은 데이터를 받는다
    }
```

종료하면서 이전 액티비티로 전달하는 액티비티

```
    intent.putExtra("메세지 태그", 값);
    setResult(RESULT_OK, intent);
    finish();
```

### 4.1.2 실습

1. EditText를 이용해서 값을 입력하고 버튼을 누를 시, 계산 페이지로 이동
2. 계산 페이지에서 인텐트를 이용해서 받은 값을 계산하고 돌아가기 버튼을 눌렀을 때 다시 전 페이지로 값 전달 
3. 계산 값을 출력한다

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/11.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/12.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/images/13.png" width="20%"></img>

>코드

[계산할 값 입력 & 결과 출력 액티비티](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/practice02_intent_pass_on_data/CalculatorInputAndResultActivity.java)

[계산 액티비티](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day9/Lesson_9_0328/app/src/main/java/com/example/lesson_9_0328/practice02_intent_pass_on_data/CalculatorExecuteActivity.java)

