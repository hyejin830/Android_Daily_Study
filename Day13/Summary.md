### 외부 DB 데이터 관리
- 어플리케이션에 외부 DB의 정보(관리자 ID, PW)나 SQL 정보에 직접 접근을 허용하지 않음
- 웹 서버를 이용하여 안드로이드 앱이 웹으로 데이터를 전달, 전달받은 웹 서버에서 DB로 데이터 전송 후 처리 결과를 다시 안드로이드 앱으로 전송

#### DB 및 웹 서버 셋팅

이클립스 설치 -> Tomcat 연동 -> Mysql 설치 -> JSP를 이용한 DB 연동

```
이클립스 : eclipse-inst-mac64
톰캣 : apache-tomcat-8.5.39 
Mysql : brew를 통한 mysql
```

#### 안드로이드에서 웹으로 데이터를 전송
안드로이드에서는 `AsyncTask`와 `HttpUrlConnection`을 이용
	
##### 1. AsyncTask
- 일반적인 자바의 스레드와 같은 개념
- execute() 메소드를 통해 실행됨
- doInBackground에서 수행할 작업을 정의

```
AsyncTask Generic 타입
AsyncTask <Params, Progress, Result> 
```

`Params` : doInBackground 파라미터 타입이 되며, execute 메소드 인자 값

`Progress` : doInBackground 작업 시 진행 단위의 타입으로

`Result` : doInBackground 리턴값

- onPreExecute()		: 비동기task를 호출한 쪽에서 실행
- onProgressUpdate()	: 비동기task에서 실행
- onPostExecute()		: 비동기task를 호출한 쪽에서 실행

##### 2. HttpURLConnection
- HTTP 요청 및 응답을 처리하기 위한 클래스
- `요청`할 때 HTTP 요청 헤더를 만들어 `Ouput Stream`을 통해 전송
- 웹 서버로부터 `응답`은 `Input Stream`을 통해 전달 받음

#### 간단한 예제
- 액티비티를 실행하면서 id와 pw값을 서버에 출력

웹 서버

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day13/images/1.png" width="50%"></img> 

#### 예제
- 2개의 EditText와 1개의 Button, 1개의 TextView을 이용
- 아이디와 비밀번호를 입력받고 버튼 이벤트를 통해 서버 데이터 전송
- 응답 메세지를 Text로 출력

어플리케이션

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day13/images/2.png" width="20%"></img> 

웹 서버

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day13/images/3.png" width="50%"></img> 
