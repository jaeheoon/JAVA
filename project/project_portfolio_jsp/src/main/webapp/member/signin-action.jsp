<%@page import="java.net.URLEncoder"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="ezen.portfolio.common.dao.DaoFactory"%>
<%@ page import="ezen.portfolio.member.dto.Member"%>
<%@ page import="ezen.portfolio.member.dao.JdbcMemberDao"%>
<%@ page import="ezen.portfolio.member.dao.MemberDao"%>

<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

String saveId = request.getParameter("saveid");

MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
Member loginMember = memberDao.findByUser(id, passwd);
if(loginMember != null){
	if(saveId != null){
		Cookie saveCookie = new Cookie("saveid", URLEncoder.encode(loginMember.getId(), "utf-8"));
		saveCookie.setPath("/");
		saveCookie.setMaxAge(60*60*24*100);
		response.addCookie(saveCookie);
	}	
}

request.setAttribute("loginMember", loginMember);
%>

<c:choose>
	<c:when test="${empty loginMember }">
		<script>
			// 추후 JavaScript2에서 Ajax를 이용한 비동기 통신 처리
			alert('아이디와 비밀번호를 확인하세요.');
			location.href= '/';
		</script>
	</c:when>
	<c:otherwise>
		<c:set var="loginMember" value="${loginMember}" scope="session"/>	
		<c:redirect url="/"/>	
	</c:otherwise>
</c:choose>


