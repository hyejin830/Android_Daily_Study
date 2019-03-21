
## Table Layout

> ##### 특징
- 뷰들을 표 형태로 배치 
 
> ##### 태그
 - TableRow : 행 생성, 내부 View들이 각 열

> ##### 속성
 - android:layout_span : 열 병합

> ##### 예제
 
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/images/1.png" width="20%"></img>
 
[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/text/TableLayout_example.txt)

> ##### 실습

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/images/2.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/text/TableLayout_Practice.txt)

## Grid Layout

> ##### 특징
 - Table Layout과 유사하지만 더 직관적

> ##### 속성
 ##### 1) GridLayout 내부
  - android:columnCount : 열의 수 지정
  - android:rowCount : 행의 수 지정

 ##### 2) View 내부
  - android:layout_column : 열의 위치 (시작-0)
  - android:layout_row : 행의 위치 (시작-0)
  - android:layout_columnSpan : 열 병합 
  - android:layout_rowSpan : 열 병합

> ##### 예제

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/images/3.png" width="20%"></img>
 
[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/text/GridLayout_Example.txt)

## EVENT

>  ##### 설명
  - 클릭 또는 드래그 등과 같은 동작들을 발생했을 때 이벤트가 발생
  - 이벤트 처리 : 해당 동작들을 어떻게 처리하는 결정하는 것
  - 이벤트 리스너(Event Listener) 객체를 생성하여 처리

>  ##### 리스너(Listener)란?
  - "듣는 사람"인 것 처럼, 안드로이드에서 비슷한 개념
  - 어떤 이벤트의 발생 여부에 귀기울이는 객체를 의미
  - View 클래스에 정의

>  ##### 방법

 1) 익명(Anonymous) 클래스 생성
   ```
Button button1 = (Button) findViewById(R.id.button1) ;
	button1.setOnClickListener(new Button.OnClickListener() {
		@Override
		public void onClick(View view) {
		// TODO : click event
		}
	});
   ```
   - 장점
     - 이벤트 처리를 직관적으로 확인 가능
     - 코드 작성이 간결
     - 가장 많이 사용되는 방법
   - 단점
     - 위젯이 많아지면 코드가 길어진다
     - 익명 클래스 외부에 있는 변수를 사용하려면 변수를 선언할 때 반드시 final 키워드 사용
 
 2) 익명(Anonymous) 클래스를 미리 만들고 참조하여 리스너 사용
   
   ```
View.OnClickListener listener = new View.OnClickListener() {
	@Override
		public void onClick(View v) {
			switch(v.getId()) {
			case R.id.btn:
				Toast.makeText(getApplicationContext(), "버튼1 선택", Toast.LENGTH_LONG).show();
				if(checkBox.isChecked()) {
				text.setText("체크박스가 체크되어있습니다.");
				} else {
				text.setText("체크박스가 체크되어있지 않습니다.");
				}
				break;
			}
		}
	};

        Button btn1 = (Button)findViewById(R.id.btn);
        btn1.setOnClickListener(listener);
   ```
  - 익명 클래스 객체를 먼저 만들어 놓고 그 객체를 모든 위젯의 이벤트 리스너로 사용
   - 매번 생성하지 않기 때문에 첫번째 방법의 문제점들을 해결
 
3)  이벤트 리스너 인터페이스를 implements하는 이벤트 리스너 클래스를 생성하여 사용 
  ```
class BtnOnClickListener implements Button.OnClickListener {
		@Override
		public void onClick(View view) {
			TextView textView1 = (TextView) findViewById(R.id.textView1);
			switch (view.getId()) {

			}
		}
	}
  ```
- 직접 클래스를 만들기 때문에 가독성이 높아짐
 
4)  Layout 리소스 XML 에서 onClick 속성 이용

 ```
// 리소스 xml 
<Button android:onClick="메소드명" />

// java 코드
public class MainActivity extends AppCompatActivity {
    public void onButtonClick(View view) {
    }
...
  ```
  - 자주 사용하지 않는 방법

## 계산기 실습

> UI 구현

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/images/4.png" width="20%"></img>
 
[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day4/text/Calculator_xml.txt)


