<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>회원 가입이 완료되었습니다. 가입하신 정보는 아래와 같습니다.</h2>
아이디 : ${member.id}<br>
이름 : ${member.name}<br>
이메일 : ${member.email}<br>
<a href='<c:url value="/index.jsp"/>'>홈으로</a>
</body>
</html>