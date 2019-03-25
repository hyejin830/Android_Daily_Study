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

// TODO : 변수명 수정하기
>java파일 적용 코드

```

String[] items = {"Avengers1","Avengers2","iron man","iron man2"};

auto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
auto.setAdapter(adapter);

MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)findViewById(R.id.multiautoCompleteTextView);
MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
multi.setTokenizer(token);
multi.setAdapter(adapter);
```

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
