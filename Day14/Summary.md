
## 외부 서버를 이용한 회원가입 및 로그인 구현

### JSP를 이용한 외부 서버 DB 연동

- 회원 가입, 로그인 서버 코드 구현

1. getParameter 메소드를 이용하여 받은 값을 저장

```
자료형 변수명 = request.getParameter("파라미터");
```

2. DB url, id, pwd 설정

```
String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/android?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Seoul";
String id = "root";
String pwd = "설정한 비밀번호";
```

3. DB Connection 및 값 조회/처리

```
Connection conn = DriverManager.getConnection(url, id, pwd);
Statement stmt = conn.createStatement();

String sql = "쿼리문";

try{
	int result = stmt.executeUpdate(sql);

	if (result == 1) {
		out.println("성공 메세지");
	} else {
		out.println("실패 메세지");
	}		
} catch(Exception e) {
	out.println(e.toString());
}

stmt.close();
conn.close();
```

첫 화면
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day14/images/1.png" width="20%"></img> 

회원 가입
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day14/images/2.png" width="20%"></img> 

DB 
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day14/images/0.png" width="50%"></img> 

로그인 시도
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day14/images/4.png" width="20%"></img> 

로그인 완료
<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day14/images/5.png" width="20%"></img> 


