<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
</head>

<body>
    <form action="<c:url value="/member/signup-action"/>" method="post">
        <table width="940" " border=" 1">
            <caption>회원가입</caption>
            <tr>
                <th> 이름</th>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
     .           <th>아이디</th>
                <td>
                    <input type="text" name="id">
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="passwd"> 영문/숫자포함 8자 이상</td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                <td><input type="password" name="re-upassword"></td>
            </tr>
            
            <tr>
                <th>이메일</th>
                <td>
                    <input type='text' name="email">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="회원가입">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>

    </form>
</body>

</html>