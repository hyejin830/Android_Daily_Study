

## Final Project [03.29~]


### 04.01 각 탭마다 다른 프래그먼트 출력하기
- 각 탭에 해당하는 Fragment class 및 xml 생성
- onNavigationItemSelectedListener 및 FragmentTransaction을 이용하여 각 탭에 맞게 replace  

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Final/images/0401/1.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Final/images/0401/2.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Final/images/0401/3.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Final/images/0401/4.png" width="20%"></img>|


### 04.05 RecyclerView를 활용한 list 생성

- Friend Tab Fragment에 RecyclerView 예제 적용
- FriendFragmentAdapter를 이용하여 List Item 생성
- add함수를 통해 리스트 아이템 초기화

```
userModelArrayList.add(new UserModel("test1","test1@test.com"));
userModelArrayList.add(new UserModel("test2","test2@test.com"));
```

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day15/images/2.png" width="20%"></img> | <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day15/images/3.png" width="20%"></img>

[final 코드로 이동](https://github.com/hyejin830/Android_Daily_Study/tree/master/Final/Final_Project)