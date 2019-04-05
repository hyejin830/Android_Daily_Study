

## Adapter View

- ListView, GridView 등과 같이 `연속된 레이아웃`을 생성할 때 사용하는 뷰
- Adapter를 사용하여 데이터 셋을 입력하면 각각의 데이터 셋이 하나의 레이아웃으로 구성

### 구성요소

Adapter : 데이터와 아이템에 대한 View생성
ViewHolder : 재활용 뷰에 대한 정보를 보유
LayoutManager : 아이템의 항목을 배치
ItemDecoration : 아이템 항목에서 뷰에 대한 처리
ItemAnimation : 아이템 항목이 추가, 제거되거나 정렬될때 애니메이션 처리


### RecyclerView
- com.android.support:design:28.0.0 라이브러리에 들어있는 어댑터 뷰 중 하나
- ListView에 비해서 확장성이 높고 유연하게 레이아웃 구성이 가능

#### 예제
- `추가`버튼을 클릭 시, 리스트에 UserInfo 항목이 생성

##### 과정
- Model 생성 
- RecyclerView.Adapter를 상속받은 ViewHolder 생성
    - ViewHolder는 커스텀 아이템을 inflate
- RecyclerView에 Adapter를 연결

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day15/images/1.png" width="20%"></img>|<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day15/images/11.png" width="20%"></img>

## SqlLite

- google api 방식의 가상머신 만들고 프로젝트를 해당 가상머신으로 시작
- 안드로이드 스튜디오에서 밑에 terminal 탭에서 명령어로 확인

```
adb root

sqlite3 [DB파일명]

.table  //명령어로 테이블 확인

-> insert into friend_list values('aaa','aaa');		
쿼리문으로 데이터 삽입
```

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/tree/master/Day15/Lesson_15_0405)

--------------

Final 

[final document](https://github.com/hyejin830/Android_Daily_Study/tree/master/Final/Summary.md)