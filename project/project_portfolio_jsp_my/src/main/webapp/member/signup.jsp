<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML>

<html>
	<head>
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<%-- CSS 파일 포함 --%>
		<jsp:include page="/modules/styles.jsp"/>
	</head>
	<body>

		<!-- ======================================== Header Start ====================================== -->
        <jsp:include page="/modules/header.jsp"/>
        <!-- ======================================== Header End ======================================== -->
			
		<!-- ======================================== Banner Start ====================================== -->
        <jsp:include page="/modules/banner.jsp"/>
        <!-- ======================================== Banner End ======================================== -->

		<!-- One -->
		<main>
      <section class="position-relative">
        <div class="bg-pattern text-primary text-opacity-50 opacity-25 w-100 h-100 start-0 top-0 position-absolute">
        </div>
        <div class="bg-gradientwhite flip-y w-50 h-100 start-50 top-0 translate-middle-x position-absolute"></div>
        <div class="container pt-11 pt-lg-14 pb-9 position-relative z-1">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-6 col-sm-8">
              <h2>
                반갑습니다!
              </h2>
              <p class="mb-3 w-lg-75">
                세부 정보를 입력하여 주세요...
              </p>
              <div class="width-50x pt-1 bg-primary mb-5"></div>

              <div class="position-relative">
                <div>
                
                  <form class="needs-validation" novalidate action="/member/signup-action.jsp" method="post">
                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-user-pin"></i>
                      </span>
                      <input type="text" class="form-control" required id="uid" name="id" autofocus placeholder="아이디">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-user"></i>
                      </span>
                      <input type="text" class="form-control" required id="uname" name="name" autofocus placeholder="이름">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-envelope"></i>
                      </span>
                      </span>
                      <input type="email" class="form-control" required id="email"  name="email" placeholder="이메일">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-lock-open"></i>
                      </span>
                      </span>
                      <input type="password" class="form-control" required id="passwd" name="passwd" placeholder="비밀번호">
                    </div>

                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-lock-open"></i>
                      </span>
                      </span>
                      <input type="password" class="form-control" required id="re-passwd" placeholder="비밀번호 확인">
                    </div>

                    <div class="d-grid">
                      <button class="btn btn-primary" type="submit">가입하기</button>
                    </div>
                  </form>
                  <p class="pt-3 small text-body-tertiary">
                    이미 계정이 있습니까? <a href="/member/login.jsp" class="ms-2 fw-semibold link-underline">로그인</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
		<p></p>
    <!-- ================================================== Main content End =================================================-->

    </div>

		<!--Footer Start-->
        <jsp:include page="/modules/footer.jsp"/>
        <!--Footer End-->

		<!-- JavaScript Start -->
   		<jsp:include page="/modules/scripts.jsp"/>
    	<!-- JavaScript End -->
	</body>
</html>