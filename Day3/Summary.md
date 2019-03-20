
## 아이디 패스워드 입력값 가져와 출력하는 실습
    - 버튼 1개에 리스너 연결
    - EditText 입력 값을 가져와 TextView에 String 형태로 출력
                
 
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/1.png" width="20%"></img>

 #### 핵심 코드 (onClick 내부)
 ```
String id = editid.getText().toString();  // EditText editid, editpw;
String pw = editpw.getText().toString();

textid.setText("입력하신 ID는 "+id+"입니다"); // TextView textid, textpw;
textpw.setText("입력하신 PW는 "+pw+"입니다");
```     

## 안드로이드 레이아웃(Layout)

#### 1) 리니어 레이아웃(LinearLayout)	

##### 특징
- 박스(Box) 모델
- 한 쪽 방향으로 차례대로 뷰를 추가하며 화면을 구성하는 방법
- 뷰가 차지할 수 있는 사각형 영역을 할당

##### 속성
(1) gravity
  - 안에 배치할 뷰의 정렬 방향을 좌측 우측 중앙으로 설정

(2) layout_gravity 
  - 자신의 위치를 부모의 어디쯤에 위치시킬지를 결정
  - gravity의 기준이 부모 (레이아웃) , 부모 안에서 개별적으로 설정하고 싶을 때 적용

(3) padding
  - 안쪽 여백 설정

(4) layout_weight 
  - 여러 개의 레이아웃을 사용할 때 레이아웃이 전체 화면에서 차지하는 공간의 가중치값을 설정
  - 가중치가 높으면 공간을 많이 차지, 낮으면 공간을 적게 차지한다
  - 예제와 실습
 ```
  android:layout_weight="1" // 가중치 값을 입력
 ```
 
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/2.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/3.png" width="20%"></img>
 
 [왼쪽 코드](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/text/layout_weight_practice.txt) [오른쪽 코드](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/text/layout_weight_practice_2.txt)
  
  - LinearLayout과 같이 잘 쓰임, 가중치를 이용하면 각각 다른 화면의 비율로 지정되서 효율적

(5) baselineAligned 
  - 안에 배치할 뷰의 배치를 보기 좋게 정렬
  - 예제
  
  ```
  android:baselineAligned="true"
  ```
  
적용 전과 적용 후

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/4.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/5.png" width="20%"></img>

#### 2) 상대 레이아웃(ReleativeLayout)	

##### 특징
- 규칙(Rule) 기반 모델
- 부모 컨테이너나 다른 뷰와의 상대적 위치로 화면을 구성하는 방법


##### 연습
- 배치
 
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/6.png" width="20%"></img> 
 
```
//가운데 위
android:layout_centerHorizontal="true"

android:layout_centerVertical="true"

//가운데 왼쪽
android:layout_alignParentLeft="true"
android:layout_centerVertical="true"

//가운데 오른쪽
android:layout_alignParentRight="true"
android:layout_centerVertical="true"

//가운데 아래쪽
android:layout_alignParentBottom="true"
android:layout_centerHorizontal="true"

//정중앙
android:layout_centerInParent="true"
```

- 기준이 하나인 경우 

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/7.png" width="20%"></img> 

 ```

// @id/base -> 기준 버튼 
// 1번
android:layout_alignTop="@id/base"
android:layout_toLeftOf="@id/base"
// 2번
android:layout_toLeftOf="@id/base"
android:layout_alignBaseline="@id/base"
// 3번
android:layout_alignBottom="@id/base"
android:layout_toLeftOf="@id/base"
// 4번   
android:layout_above="@id/base"
android:layout_alignStart="@id/base"
// 5번
android:layout_below="@id/base"
android:layout_alignEnd="@id/base"

 ```


- 기준이 두개 이상인 경우

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/8.png" width="20%"></img> 


##### 실습 과제
LinearLayout 과 RelativeLayout 버전 모두 만들기

- LinearLayout 의 경우      - RelativeLayout 의 경우
 
 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/9.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/images/10.png" width="20%"></img> 

- 코드
[LinearLayout](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/text/Assignment_LinearLayout_Version.txt) 
[RelativeLayout](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day3/text/Assignment_RelativeLayout_Version.txt)





