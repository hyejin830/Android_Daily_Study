## AOSP Java Code Style for Contributors

AOSP : Android Open Source Project

CamelCase 사용

1) Java 언어 규칙
   - 예외처리를 무시하면 안된다
     - 실제 코드 상에서 있을 수 있는 일
   - 캐치 오류
     - Exception만 사용하면 비용 소모가 더 크다
     - 실제 코드 상에서 있을 수 있는 일 
   - 파이널라이저 사용 하지마
     - java finalize 나중에 찾아보기 
   - 임포트
     - 대부분 자동 완성 옵션이 있기 때문에  

2) Java 라이브러리 규칙

3) Java 스타일 규칙
 
Javadoc : 코드를 도튜먼트화 , format이 있다
 - 쓰는 습관이 있으면 좋다
 - 문서화 가능하기 때문에 사용

원칙 - 길지 않게 작성하기 

쏘나큐브
 : 코드의 외부 프레임워크

 * 알면 좋은 것 : 단축키
 ctrl + option + o : 임포트 자동 정렬
 option + command + l : 자동 정렬

 - TODO : 해야 될 것 , 나중에 잘 쓰면 좋다

일관성 있게 해라, 거기다 융통성 발휘해서 해라.

 # project and code guidelines

## 1. 프로젝트 가이드라인

### 1.1 프로젝트 구조

### 1.2 파일 이름 지정

#### 1.2.1 클래스 파일

컴포넌트의 이름으로 끝나야 한다.

for example : SignInActivity, SignInFragment 등

#### 1.2.2 리소스 파일
- 소문자와 언더바를 이용

    ##### 1.2.2.1 그림 파일
        Action bar      : ab_ 
        Button          : btn_
        Dialog          : dialog_
        Divider         : divider_
        Icon            : ic_
        Menu            : menu_
        Notification    : notification_
        Tabs            : tab_
    ##### 1.2.2.2 레이아웃 파일
    >컴포넌트 이름이 시작
        
        Activity        : activity_
        Fragment        : fragment_
        Dialog          : dialog_
        AdapterView item : item_

    ##### 1.2.2.3 메뉴 파일
    ##### 1.2.2.4 값 파일

## 2) 코드 가이드라인

### 2.1 Java 언어 규칙
- 총 4가지
    #### 2.1.1 예외 무시하지 않기
    #### 2.1.2 기본 예외 처리하지 않기
    #### 2.1.3 파이널라이저 사용하지 않기
    #### 2.1.4 임포트 정확하게 하기

### 2.2 자바 스타일 규칙

#### 2.2.1 필드 정의 및 이름 짓기

- m으로 시작 : Private, non-static field name ex) int mPackagePrivate, private
- s로 시작 : Priatave, static field names ex) private static MyClass sSingleton
- 소문자로 시작 : Other field
- 모두 대문자 : Static final field

#### 2.2.10 클래스 멤버 순서

1. Constants
2. Fields
3. Constructors
4. Override methods and callbacks (public or private)
5. Public methods
6. Private methods
7. Inner classes or interfaces

### 2.3 XML 스타일 규칙

2.3.1 셀프 닫히는 태그 사용

<TextView 
    ...
    ... 


### 4.2 테스트 스타일 규칙

옥토트리 
주석 처리 열심히하기
네이밍 잘하기 

!좋은 자료! 답은 아니다~
https://brunch.co.kr/@goodvc78/12






