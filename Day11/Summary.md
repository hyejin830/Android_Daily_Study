
## 프래그먼트 (Fragment)
하나의 액티비티가 `여러 개의 화면`을 가지도록 만들기 위해 고안된 개념
다양한 크기의 화면을 가진 모바일 환경이 늘어남에 따라 하나의 디스플레이 안에서 아이패드, 갤럭시 탭과 같은 다양한 화면 요소들을 보여야 하는 경우가 생기게 되었고 이를 좀 더 쉽게 구현하기 위해 나온 개념

### 1. 기본적인 사용법
#### 1.1 각 프래그먼트를 위한 레이아웃 XML 파일 생성

#### 1.2 프래그먼트 클래스 구현
```
public class ExampleFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_example, container, false);
    }

}
```

#### 1.3 액티비티에서 프래그먼트 추가

1.3.1 XML파일 이용해서 추가
```
<fragment
    android:id="@+id/프래그먼트 아이디"
    android:name="프래그먼트 클래스 파일 이름"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_weight="1" />
```
1.3.2 Java코드에서 추가
```
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.add(뷰그룹, new 프래그먼트 클래스);
fragmentTransaction.commit();
```

#### 1.4 FragmentTranscation을 사용하여 프래그먼트 제어
```
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fm.beginTransaction();
Fragment fragment;
fragment = new SampleFragment1();

fragmentTransaction.replace(변경할뷰의ID, fragment);
```

### 2.기본 예제 
- 2개의 XML파일을 이용한 프래그먼트 추가
- 1개의 LinearLayout(ViewGroup)에 Java코드에서 프래그먼트 추가

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day11/images/1.png" width="20%"></img>

### 3.실습 
 * 액티비티 세로 화면일 경우 : 프래그먼트와 버튼1개 , 버튼을 누를 때마다 프래그먼트가 바뀌는 액션
 * 액티비티 가로 화면일 경우 : 프래그먼트 2개 보이기
 * 화면 회전에 따라 다른 페이지 출력하게끔 하기
   - `화면의 크기에 따른 분기문`을 통해 뷰 처리를 해줘야 한다

```
// 화면의 크기를 가져오기 위한 과정
Point point = new Point();
getWindowManager().getDefaultDisplay().getSize(point);
((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(point);

int width = point.x;
int height = point.y;

if (height > width) { // 세로 모드일 경우 
    doChangeFragmentButton = findViewById(R.id.btn_do_change_fragment);
    doChangeFragmentButton.setOnClickListener(this);
    currentFragmentIndex = 0;
}
```

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day11/images/2.png" width="20%"></img> |  <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day11/images/3.png" width="20%"></img> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day11/images/4.png" width="60%"></img> 

