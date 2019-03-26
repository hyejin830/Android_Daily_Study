
#### 메뉴

>Option Menu

- 메뉴 XML 파일 생성

res 우클릭 -> new -> Android Resource Directory -> Resource Type을 menu로 선택 후 OK

생성된 menu 폴더 우클릭 -> new -> Menu Resource File -> xml파일 이름 입력 후 ok 

- 메뉴 파일 등록

```
onCreateOptionsMenu(Menu menu) {
	super.OptionsMenu(menu);
	MenuInflater mInflater = getMenuInflater();
	mInflater.inflate(R.menu.메뉴xml파일이름, menu)
	return true;
}			
```
##### * Inflator (인플레이터)
: xml파일을 화면에 표시해주기 위해서 객체를 만들고 메모리에 실행하는 과정을 인플레이션이라고 한다. 인플레이션을 해주는 클래스를 인플레이터라고 한다.
LayoutInflator 클래스로부터 inflate 메소드 사용

- 메뉴 선택 시 작동할 내용 코딩

```
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
		case R.id.itemRed:
			작동할 코드;
			return true;
		}
		
		return false;
	}
```
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/images/1.png" width="20%"></img>
 
[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/Lesson_7_0326/app/src/main/java/com/example/lesson_7_0326/example01_menu/OptionAndContextMenuActivity.java)

>Context Menu
 특정 위젯을 롱클릭했을 때 뜨는 메뉴

- 메뉴용  XML 파일 생성
 option menu와 동일

- 메뉴를 사용할 위젯 등록

```
registerForContextMenu(Widget 변수);
```

- 메뉴 XML 파일 등록
 option menu와 동일

- 메뉴 선택 시 작동할 코드
 option menu와 동일

- 기본 예제 (영화)
  
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/images/2.png" width="20%"></img>
 
[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/Lesson_7_0326/app/src/main/java/com/example/lesson_7_0326/example01_menu/ContextMenuExampleActivity.java)

- 기본 예제 2 (영화,애니메이션 2가지)

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/images/3.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/images/4.png" width="20%"></img> 

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/Lesson_7_0326/app/src/main/java/com/example/lesson_7_0326/example01_menu/ContextMenuPracticeActivity.java)

#### 대화상자
:사용자와 마치 대화를 하듯 사용자에게 중요한 사항을 알려준 후 어떤 선택을 하게 하는 것이 목적

* 윈도우의 MessageBox와 비슷함
* 자바 스크립트에서는 alert

1. 대화상자 생성
    AlertDialog.Builder 클래스 생성

2. 용도에 따른 설정

```
    .setTitle
    .setMessage
    .setIcon
    .setPositiveButton
    .setNegativeButton
    .setItems
```

3. 대화상자 화면 출력
    .show()

- 기본 예제
    - 확인, 취소, 아이템

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/images/5.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day7/Lesson_7_0326/app/src/main/java/com/example/lesson_7_0326/example02_dialog/DialogExampleActivity.java)

#### 실습

- 옵션 메뉴 : 영화, 애니메니션 선택
- 컨텍트 메뉴 : 영화 목록 4개, 애니메이션 목록 4개



