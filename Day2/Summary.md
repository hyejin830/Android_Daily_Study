## 안드로이드 기본 용어

#### 1)	액티비티 (Activity)
-	안드로이드 4대 컴포넌트 중 하나
-	하나의 액티비티는 리소스 파일과 자바 파일을 가진다.

#### 2)	레이아웃 (Layout) 
-	내부 내용 배치 

#### 3)	뷰 (View)
-	화면을 구성하는 각각의 요소
-	안드로이드에서 사용되는 모든 뷰는 View 클래스 상속
-	종류 : 버튼, 텍스트, 리시트, 그리드, 이미지, 체크박스 등등

* * *
## 안드로이드 뷰 (View)

#### 1)	뷰의 XML 속성
-	android:layout_width : 가로 속성 / android:layout_height : 세로 속성
    -	wrap_content : 자신의 폭이나 높이를 자신 안의 내용에 맞춤
    -	match_parent : 자신이 부모에 폭이나 높이를 맞춤
-	android:id : 원하는 값은 나중에서 java 파일에서 해당 버튼을 생성
    -	@+id/[원하는값]

-	android:text : 뷰에 들어갈 텍스트 내용
-	android:textSize : 텍스트의 폰트 크기

-	android:padding : 뷰의 안쪽 간격 조정
-	android:layout_margin : 뷰의 바깥쪽 간격 조정

-	android:visibility : 시각적으로 보이는 유무 조정 
-	android:enabled : 이용 가능한지 조정
-	android:clickable : 클릭 가능한지 조정

#### 2)	다양한 뷰
-	TextView : 텍스트를 나타내는 뷰
-	EditText : 텍스트 입력을 할 수 있는 뷰
-	CheckBox : 체크를 할 수 있는 뷰 (다중 선택)
-	RadioButton : RadioGruop을 사용하여 단일 선택하게 하는 뷰
-	Switch : 스위치
-	ToggleButton : 토글 버튼
-	ImageView : 그림파일 위치 지정, 그림 파일은 일반적으로 res/drawable 저장
