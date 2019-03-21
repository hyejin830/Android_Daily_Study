
1. Table Layout

> 특징
 - 뷰들을 표 형태로 배치 
 - 예제(이미지1) 및 실습(이미지2) 
 
> 태그
 - TableRow : 행 생성, 내부 View들이 각 열

> 속성
 - android:layout_span : 열 병합

2. Grid Layout

> 특징
 - Table Layout과 유사하지만 더 직관적
 - 예제(이미지3)

> 속성
 # GridLayout 내부
  - android:columnCount : 열의 수 지정
  - android:rowCount : 행의 수 지정

 # View 내부
  - android:layout_column : 열의 위치 (시작-0)
  - android:layout_row : 행의 위치 (시작-0)
  - android:layout_columnSpan : 열 병합 
  - android:layout_rowSpan : 열 병합


3. 안드로이드 이벤트

> 설명
  - 

> 리스너(Listener)란?
  - "듣는 사람"인 것 처럼, 안드로이드에서 비슷한 개념
  - 

> 방법

 1) 익명(Anonymous) 클래스 생성
 2) 
 3) 
 



