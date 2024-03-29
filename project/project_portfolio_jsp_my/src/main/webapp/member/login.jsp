<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<html>

<head>
  <title>로그인</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  
  	<%-- CSS 파일 포함 --%>
	<jsp:include page="/modules/styles.jsp"/>
	<link rel="stylesheet" type="text/css" href="/assets/css/my-login.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>

<body class="my-login-page">
  <section class="h-100">
    <div class="container h-100">
      <div class="row justify-content-md-center h-100">
        <div class="card-wrapper">
          <div class="brand">
            <img src="/assets/images/logo.jpg" alt="logo">
          </div>
          <div class="card fat">
            <div class="card-body">
              <h4 class="card-title">Login</h4>
              <form method="POST" class="my-login-validation" novalidate action="signin-action.jsp">
                <div class="form-group">
                  <label for="email">E-Mail Address</label>
                  <input id="id" type="text" class="form-control" name="id" value="${cookie.saveid.value}" required autofocus>
                  <div class="invalid-feedback">
                    Email is invalid
                  </div>
                </div>

                <div class="form-group">
                  <label for="passwd">Password
                    <a href="/" class="float-right">
                      홈으로
                    </a>
                  </label>
                  <input id="passwd" type="password" class="form-control" name="passwd" required data-eye>
                  <div class="invalid-feedback">
                    Password is required
                  </div>
                </div>

                <div class="form-group">
                  <div class="custom-checkbox custom-control">
                    <input type="checkbox" name="saveid" id="remember" class="custom-control-input" <c:if test="${not empty cookie.saveid}">checked</c:if>>
                    <label for="remember" class="custom-control-label">Remember Me</label>
                  </div>
                </div>

                <div class="form-group m-0">
                  <button type="submit" class="btn btn-primary btn-block">
                    Login
                  </button>
                </div>
                <div class="mt-4 text-center">
                  계정이 없으십니까? <a href="signup.jsp"> 회원가입하기 </a>
                </div>
              </form>
            </div>
          </div>
          <div class="footer">
            Copyright &copy; 2017 &mdash; Your Company
          </div>
        </div>
      </div>
    </div>
  </section>

  		<!-- JavaScript Start -->
   		<jsp:include page="/modules/login-script.jsp"/>
    	<!-- JavaScript End -->
</body>

</html>