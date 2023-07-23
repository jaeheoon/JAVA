<%@ page contentType="application/json; charset=utf-8" %>
<%@ page import="ezen.shoppingmall.domain.member.dto.Member"%>
<%@ page import="java.util.List"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%-- Rest API Service --%>
<%
	List<Member> members = (List<Member>)request.getAttribute("members");
	ObjectMapper objectMapper = new ObjectMapper();
	// 직렬화
	String memberJson = objectMapper.writeValueAsString(members);
	out.println(memberJson);
%>