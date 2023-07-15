<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header-fixed-top header-transparent z-fixed">
	<nav class="navbar navbar-expand-lg navbar-light py-3">
		<div class="container position-relative">
			<a class="navbar-brand width-3x" href="/"> <img
				src="/assets/img/icon.png" alt=""
				class="img-fluid navbar-brand-light">
			</a>

			<div
				class="d-flex align-items-center navbar-no-collapse-items order-lg-last">
				<div class="nav-item me-3 dropdown">
					<a href="mailto:bangry313@gmail.com" class="btn btn-success py-1">😊
						연락주세요...</a>
				</div>
				<div class="nav-item me-3 dropdown">
					<a href="/article/articlesv3.jsp" class="btn btn-primary py-1">게시글</a>
				</div>
				
				
				<div class="nav-item me-3 <c:if test="${empty loginMember }">dropdown</c:if>">
					<c:choose>
						<c:when test="${empty loginMember}">
							<a href="#"
								class="btn btn-outline-primary px-4 btm-sm rounded-pill py-1"
								data-bs-auto-close="outside" data-bs-toggle="dropdown"> 로그인
							</a>
						</c:when>
						<c:otherwise>
							<span class="badge rounded-pill text-bg-warning me-3 p-2">${loginMember.id}(${loginMember.name})님 로그인중...</span>
							<a href="/member/signout-action.jsp"
								class="btn btn-primary btn-sm px-4 btm-sm rounded-pill py-1"
								data-bs-auto-close="outside"> 로그아웃
							</a>
						</c:otherwise>
					</c:choose>

					<div class="dropdown-menu dropdown-menu-end dropdown-menu-xs p-4">
						<!-- Sign In Form Start-->
						<form class="needs-validation" novalidate
							action="/member/signin-action.jsp" method="post">
							<div>
								<h3 class="mb-1">환영합니다!</h3>
								<p class="mb-4 text-body-secondary">아이디와 비번을 입력하여 주세요.</p>
							</div>
							<div class="input-icon-group mb-3">
								<span class="input-icon"> <i class="bx bx-envelope"></i>
								</span> <input type="text" name="id" value="${cookie.saveid.value}" required class="form-control"
									autofocus="" placeholder="아이디">
							</div>
							<div class="input-icon-group mb-3">
								<span class="input-icon"> <i class="bx bx-key"></i>
								</span> <input type="password" name="passwd" required
									class="form-control" placeholder="비밀번호">
							</div>
							<div class="mb-3 d-flex justify-content-between">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" 
										id="flexCheckDefault" name="saveid" 
										<c:if test="${not empty cookie.saveid}">checked</c:if>> <label
										class="form-check-label" for="flexCheckDefault"> 아이디
										저장 </label>
								</div>

							</div>

							<div class="d-grid">
								<button class="btn btn-primary btn-hover-arrow" type="submit">
									<span>로그인</span>
								</button>
							</div>
							<p class="pt-4 mb-0 text-body-secondary text-end">
								<a href="/member/signup.jsp" class="ms-2 pb-0 link-underline">회원가입</a>
							</p>
						</form>
						<!-- Sign In Form End-->
					</div>

				</div>
				<div class="nav-item me-3 me-lg-0">
					<a data-bs-toggle="offcanvas" href="#offcanvasEnd"
						class="nav-link ms-3"> <svg xmlns="http://www.w3.org/2000/svg"
							width="32" height="32" fill="currentColor" class="bx bx-list"
							viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
								d="M2.5 11.5A.5.5 0 0 1 3 11h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 7h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 3h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z">
                            </path>
                        </svg>
					</a>
				</div>
			</div>
		</div>
	</nav>
</header>