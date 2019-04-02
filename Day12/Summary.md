
## 프래그먼트 생명주기

#### 1. onAttach
프래그먼트가 처음으로 액티비티에 추가될 때 호출
	
#### 2. onCreate
- 프래그먼트에 꼭 필요한 요소들을 먼저 초기화 하고 시작
- 아직 액티비티도 만들어지는 중
- UI초기화는 다음 단계에서 진행

#### 3. onCreateView
프래그먼트 레이아웃을 인플레이션하는 단계 

#### 4. onActivityCreated
- onCreate 함수의 역할과 같이 프래그먼트의 구성요소들을 초기화 하는 시점
- 액티비티가 완전히 생성된 이후의 시점이기 때문에 액티비티의 컨트롤들에 접근하거나 프래그먼트의 구성요소들을 초기화 할 때 안전성을 보장받게 됨

#### 5. onPause
프래그먼트가 정지 되는 시점
프래그먼트의 정지가 반드시 소멸을 의미하는것은 아니지만 
다시 해당 프래그먼트로 돌아온다는 보장도 없기 때문에 
이 시점에서 남겨두어야 하거나 영구적으로 보존해야 할 자료들을 저장

Started 
Resumed
Paused
Stopped
Destroyed

- 예제
  - 하나의 리니어레이아웃에 프레그먼트를 2개를 버튼 이벤트를 통해 번갈아 생성하는 예제로,
액티비티와 프래그먼트의 생명주기를 알 수 있다.
  - 액티비티와 프래그먼트에 토스트를 띄어 주기를 확인한다.

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/1.png" width="20%"></img> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/2.png" width="20%"></img> |<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/3.png" width="20%"></img> 

- 액티비티와 프래그먼트 
액티비티에서 프래그먼트의 텍스트 값을 변경하고, 프래그먼트에서 액티비티의 텍스트 값을 변경할 수 있다.

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/5.png" width="20%"></img> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/6.png" width="20%"></img> |<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/7.png" width="20%"></img> 

## 데이터 저장 및 관리

### SQLite
- 모든 애플리케이션은 내부에서 구조적 데이터를 저장하고 사용하는 방법 있음
이런 경우를 위해 설계된 SQLite는 클라이언트 응용 프로그램에 
- 임베디드되어 동작하는 오픈 소스 DBMS의 일종
- C로 작성됐으며 일반적인 SQL로 쿼리가 가능

(1) adb 쉘에서 기본적인 사용법

	.table		테이블 조회
	.schema		테이블 형식 조회
	.header on	SELECT문 실행 시 헤더 포함
	.mode column	SELECT문 실행 시 칼럼 모드로 출력
	.exit		종료


(2) 안드로이드에서 SQLite 프로그래밍
	SQLiteOpenHelper 클래스, SQLiteDatabase 클래스, Cursor 인터페이스를 활용


    1. SQLiteOpenHelper
	생성자 : DB를 생성
	onCreate : 테이블 생성
	onUpgrade : 테이블 삭제 후 다시 생성
	getReadableDatabase() : 읽기 전용 DB 열기
	getWritableDatabase() : 읽기 전용 DB 열기


    2. SQLiteDatabase
	execSQL : SQL문 실행
	close : DB 닫기
	query, rawQuery : select 실행 후 커서 반환

    3. Cursor
	moveToFirst : 커서를 첫 행으로 이동
	moveToLast : 커서를 마지막 행으로 이동
	moveToNext : 현재 커서의 다음 행으로 이동

- 예제 

내장 DB를 생성하고
이름과 나이를 통해 추가, 조회
이름을 통해 수정, 삭제를 할 수 있다

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/8.png" width="20%"></img>  | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day12/images/9.png" width="20%"></img> 