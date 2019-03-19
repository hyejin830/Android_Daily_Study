## 개발 환경 셋팅
#### 1. JDK 설치
   - 환경 변수 설정
#### 2. Android Studio 설치
 
## 기본 프로젝트 생성 연습
#### 1.메인 화면 구성
    app/res/layout/activity_main.xml	: 

#### 2.메인 화면 동작 구현 코드 작성 
    app/java/com.example.myapplication2/MainActivity.java 

#### 3.안드로이드 프로젝트의 필수 파일, 패키지 이름, 버전, 권한 등을 설정
    app/manifests/AndroidManifest.xml
    
 ## 버튼과 버튼 이벤트 연습
- Button의 xml 속성 종류와 설명
```
<Button				<!--버튼 뷰 추가-->		
  android:layout_width="match_parent"	<!--버튼 뷰의 가로 길이-->
  android:layout_height="wrap_content"	<!--버튼 뷰의 세로 길이-->
  android:text="확인2"			<!--버튼 뷰의 내용-->
  android:textSize="30dp"		<!--버튼 뷰의 내용의 크기-->
  android:id="@+id/button2"		<!--버튼 뷰의 id값, 나중에 java 파일에서 접근할 때 사용-->
/>
```
- xml 파일에서 id 값을 지정한 후, java 파일에서 id 값을 활용하여 이벤트를 적용시킨다.

```
View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) { // switch~case 문을 사용하여 각 id 값을 분류
                    case R.id.button1: 
                        Toast.makeText(getApplicationContext(), "버튼1 선택", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button2:
                        Toast.makeText(getApplicationContext(), "버튼2 선택", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button3:
                        Toast.makeText(getApplicationContext(), "버튼3 선택", Toast.LENGTH_LONG).show();
                        break;
                }
            }
};
```
- OnClickListener를 각 뷰의 리스너로 설정한다
```
        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(listener);

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(listener);

        Button btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(listener);
```
