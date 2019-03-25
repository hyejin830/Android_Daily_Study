## 고급 위젯

#### 1) 날짜 및 시간 관련 위젯

>AnalogClock / DigitalClock
- 아날로그, 디지털 시계
```
    <AnalogClock
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
    <DigitalClock
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"/>        
```

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/1.png" width="20%"></img>

 [코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/Lesson_5_0322/app/src/main/java/com/example/lesson_5_0322/example01/WidgetExampleActivity.java)

>Chronometer

```
    <Chronometer
        android:format="시간 측정 : %s"
        android:gravity="center"
        android:textSize="30dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

>TimePicker

```
     <TimePicker
        android:timePickerMode="spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```
>DatePicker

```
    <DatePicker
        android:datePickerMode="spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

>날짜 및 시간 관련 뷰로부터 값 받아오기

```
뷰클래스 변수;
변수 = (뷰클래스)findViewById(R.id.[값]);
변수.getYear();		                //년도 받아오기
변수.getMonth()+1;	                //월 받아오기
변수.getDayOfMonth();	                //날짜 받아오기
변수.getCurrentHour();	                //시간 받아오기
변수.getCurrentMinute();	                //분 받아오기
```

>전체 실습 : 예약 시간 액티비티

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/10.png" width="20%"></img>

 [코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/Lesson_5_0322/app/src/main/java/com/example/lesson_5_0322/example02/ReservationTimeActivity.java)

#### 2) 자동완성(멀티)텍스트뷰

>AutoCompleteTextView

```
 <AutoCompleteTextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:completionThreshold="2"  <!-- 입력값이 몇자리 이상일 때 자동완성 -->
        android:completionHint="선택하세요" <!-- 리스트 하단에 뜨는 문자 -->
        android:hint="자동완성텍스트뷰"/>
```

>MultiAutoCompleteTextView

```
    <MultiAutoCompleteTextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:completionHint="선택하세요"
        android:hint="자동완성멀티텍스트뷰"/>

```

>java파일 적용 코드

```

    String[] items = {"Avengers1","Avengers2","iron man","iron man2"};
    autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.tv_auto_complete);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
    autoCompleteTextView.setAdapter(adapter);

    multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.tv_multi_auto_complete);
    MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
    multiAutoCompleteTextView.setTokenizer(token);
    multiAutoCompleteTextView.setAdapter(adapter);
```
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/2.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/3.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/Lesson_5_0322/app/src/main/java/com/example/lesson_5_0322/example03/AutoCompeleteTextViewActivity.java)

#### 바

>ProgressBar : 진행상황을 알려주는 바

```
    <ProgressBar
        style="?android:attr/progressBarStyleHorizontal"
        android:max="100"    <!-- -->
        android:progress="20"  <!-- -->
        android:layout_width="match_parent" <!-- -->
        android:layout_height="wrap_content" />
```

>SeekBar : 볼륨 키에 쓰이는 바

```
    <SeekBar
        android:progress="50"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

>RatingBar : 평점 바

```
<RatingBar
        android:numStars="7"
        android:stepSize="0.5"
        android:rating="3.5"     
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/4.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/5.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/Lesson_5_0322/app/src/main/java/com/example/lesson_5_0322/example04/PracticeBarActivity.java)


#### View Container

>ScrollView : 수직으로 스크롤하는 뷰
- 스크롤뷰 안에 레이아웃 추가 후 레이아웃 뷰를 추가

```
// 수직으로 스크롤하는 기능의 뷰
<ScrollView 
	android:layout_width="fill_parent"
	android:layout_height="fill_parent"
	android:orientation="vertical" >
	... />
// 수평으로 스크롤하는 기능의 뷰
<HorizontalScrollView
	android:layout_width="fill_parent"
	android:layout_height="fill_parent"
	android:orientation="vertical" >
    ... />
```

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/6.png" width="20%"></img>

 [코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/Lesson_5_0322/app/src/main/java/com/example/lesson_5_0322/example05/ScrollViewActivity.java)

>SlidingDrawer : 서랍처럼 열어서 보여주거나 닫아서 감춤

```
 <SlidingDrawer
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:content="@id/content"       <!-- 내용을 담을 곳 -->
        android:handle="@id/bt_slider">     <!-- 슬라이딩 액션 버튼 -->
        ....                            </SlidingDrawer>
```

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/8.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/images/9.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day5/Lesson_5_0322/app/src/main/java/com/example/lesson_5_0322/example06/SlidingDrawerActivity.java)

