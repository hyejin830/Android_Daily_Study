
#### View Container_2

> View Flipper

 내부의 여러 개의 위젯을 배치한 후 필요에 따라서 화면을 왼쪽과 오른쪽으로 밀어서 하나의 위젯씩 보여주는 방식의 뷰 컨테이너

 - 이전 보기와 다음 보기 예제 (showPrevious(),showNext() 사용)
  
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/images/1.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/Lesson_6_0325/app/src/main/java/com/example/lesson_6_0325/example01_viewflipper/ViewFlipperActivity.java)

 - 슬라이드 쇼 실습
    - startFlipping(), stopFlipping() 사용
    - 1초 단위로 화면이 자동으로 넘어감
  
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/images/2.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/Lesson_6_0325/app/src/main/java/com/example/lesson_6_0325/example01_viewflipper/SlideShowPracticeActivity.java)

> Tab Host

여러 탭을 두고 각 탭을 클릭할 때마다 해당 화면이 나오도록 설정하는 뷰

- 예제
 : 음악별, 가수별, 앨범별 탭 - 각 탭 마다 색 다름

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/images/3.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/Lesson_6_0325/app/src/main/java/com/example/lesson_6_0325/example02_tabhost/TabHostActivity.java)

- 이미지 배치 실습
 : 영화이미지 4개를 이용하여 탭 구현

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/images/4.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/Lesson_6_0325/app/src/main/java/com/example/lesson_6_0325/example02_tabhost/FourImageTabHostActivity.java)

#### Action Bar
 여러 화면을 사용하기 위해서 고안, 메뉴 아이템처럼 사용

 - 프래그먼트 활용 예제
    프래그먼트 : 액티비티보다 작은 단위의 화면. 화면을 분할해서 사용할 때 사용, 동적으로 화면을 추가/제거하는데 사용한다

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/images/5.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/Lesson_6_0325/app/src/main/java/com/example/lesson_6_0325/example03_actionbar/ActionBarActivity.java)


#### Web View

인터넷 브라우저처럼 동작하는 뷰
+ 인터넷 접근 권한이 필요 (AndroidManifest에서 설정)

```
<uses-permission android:name="android.permission.권한"></uses-permission>
```
- 예제

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/images/6.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day6/Lesson_6_0325/app/src/main/java/com/example/lesson_6_0325/example04_webview/WebViewActivity.java)
