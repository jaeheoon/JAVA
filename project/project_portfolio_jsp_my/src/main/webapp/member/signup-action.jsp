<%@ page contentType="text/html; charset=utf-8" %>

<%@ page import="ezen.portfolio.common.dao.DaoFactory"%>
<%@ page import="ezen.portfolio.member.dao.JdbcMemberDao"%>
<%@ page import="ezen.portfolio.member.dao.MemberDao"%>
<%@ page import="ezen.portfolio.member.dto.Member"%>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="member" class="ezen.portfolio.member.dto.Member" scope="session"/>
<jsp:setProperty property="*" name="member"/>

<%
// 폼 전송 데이터 유효성 검증 작업 (편의상 생략)
MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
memberDao.create(member);
System.out.println("회원 가입 완료!!!");
response.sendRedirect("/");
%>
















