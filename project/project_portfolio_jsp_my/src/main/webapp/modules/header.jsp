<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header -->
<header id="header">
	<div class="inner">
		<a href="/" class="logo">Portfolio of JaeHeon</a>
		<nav id="nav">
			<a href="/">Home</a> <a href="/article/articles.jsp">게시판</a> 
			<c:choose>
						<c:when test="${empty loginMember}">
							<a class="nav-link" href="/member/login.jsp">Log in</a>
						</c:when>
						<c:otherwise>
							<a href="/member/signout-action.jsp" class="nav-link" data-bs-auto-close="outside"> Log out</a>
							<span class="" style="vertical-align: middle;">${loginMember.name}님 반가워요!</span>
						</c:otherwise>
					</c:choose>
		</nav>
		<a href="#navPanel" class="navPanelToggle"><span
			class="fa fa-bars"></span></a>
	</div>
</header>

