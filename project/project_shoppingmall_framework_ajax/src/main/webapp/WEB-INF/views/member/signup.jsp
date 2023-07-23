<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <%-- CSS 파일 포함 --%>
    <jsp:include page="/WEB-INF/views/modules/styles.jsp"/>
    <script defer src="/js/validator.js"></script>
    <script defer src="/js/id-check.js"></script>
    
    <title>Portfolio</title>
</head>

<body>
    
    <div data-scroll-container>
        <!-- ======================================== Header Start ======================================== -->
        <jsp:include page="/WEB-INF/views/modules/header.jsp"/>
        <!-- ======================================== Header End ======================================== -->

        <!-- Option Menu Start-->
        <jsp:include page="/WEB-INF/views/modules/option.jsp"/>
        <!-- Option Menu End-->

		<!-- ================================================== Main content Start =================================================-->
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
                
                  <form class="needs-validation" novalidate action="${path}/member/signup" method="post">
                    <div class="input-icon-group mb-3">
                      <span class="input-icon">
                        <i class="bx bx-user-pin"></i>
                      </span>
                      <input type="text" class="form-control" required id="uid" name="id" autofocus placeholder="아이디">
                    </div>
                    
                    <div>
                      <p id="dup-result" class=""></p>
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
                    이미 계정이 있습니까? <a href="#" class="ms-2 fw-semibold link-underline">로그인</a>
                  </p>

                  <!--Divider-->

                  <div class="d-flex align-items-center py-3">
                    <span class="flex-grow-1 border-bottom pt-1"></span>
                    <span
                      class="d-inline-flex flex-center mx-1 lh-1 width-2x height-2x rounded-circle bg-body text-mono">OR</span>
                    <span class="flex-grow-1 border-bottom pt-1"></span>
                  </div>

                  <div class="d-grid">
                    <a href="#" class="d-flex hover-lift btn-secondary mb-2 btn position-relative flex-center">
                      <!--Main Icon-->
                      <div class="position-relative d-flex align-items-center">
                        <img src="/assets/img/brands/google.svg" alt="" class="width-2x me-2">
                        <span class="fs-6">sign up with google</span>
                      </div>
                    </a>
                    <a href="#" class="d-flex hover-lift btn-secondary btn position-relative flex-center">
                      <!--Main Icon-->
                      <div class="position-relative d-flex align-items-center">
                        <img src="/assets/img/brands/Facebook.svg" alt="" class="width-2x me-2">
                        <span class="fs-6">sign up with facebook</span>
                      </div>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
    <!-- ================================================== Main content End =================================================-        

        <!--Footer Start-->
        <jsp:include page="/WEB-INF/views/modules/footer.jsp"/>
         <!--Footer End-->
    </div>
    
    <!-- JavaScript Start -->
    <jsp:include page="/WEB-INF/views/modules/scripts.jsp"/>
     <!-- JavaScript End -->
</body>

</html>