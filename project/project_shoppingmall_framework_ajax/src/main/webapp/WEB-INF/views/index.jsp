<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <%-- CSS 파일 포함 --%>
    <jsp:include page="/WEB-INF/views/modules/styles.jsp"/>
    
    <title>Portfolio</title>
</head>

<body>
    <!--Preloader Spinner-->
    <jsp:include page="/WEB-INF/views/modules/preloader.jsp"/>
    
    <div data-scroll-container>
        <!-- ======================================== Header Start ======================================== -->
        <jsp:include page="/WEB-INF/views/modules/header.jsp"/>
        <!-- ======================================== Header End ======================================== -->

        <!-- Option Menu Start-->
        <jsp:include page="/WEB-INF/views/modules/option.jsp"/>
        <!-- Option Menu End-->

        <!--page-introduce Start-->
        <section class="position-relative overflow-hidden bg-gradient-blur" data-scroll-section>
            <div class="container position-relative z-1">
                <div class="row vh-100 align-items-center">
                    <div class="col-xl-10 mx-auto">
                        <div class="d-inline-flex">
                            <ul class="js-hover-img">
                                <li class="js-hover-img-item">
                                    <h1 class="js-hover-img-link display-1 mb-0">
                                        <small class="fs-3 ls-1 fw-normal">👋안녕하세요, 저는 홍길동, 27세, 웹 애플리케이션 개발자
                                            입니다.</small><br>
                                        Font-end Developer and Back-end Developer.
                                    </h1>
                                    <img src="assets/img/md2.jpg" alt="Image" class="img height-2x0 w-auto">
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--page-introduce End-->

        <section class="position-relative overflow-hidden" data-scroll-section>
            <div class="width-20x height-20x position-absolute end-0 bottom-0 me-3 mb-n4 bg-info-subtle d-none d-md-block rounded-circle"
                data-scroll data-scroll-direction="vertical" data-scroll-speed="6">
            </div>
            <div class="width-20x height-20x position-absolute start-0 top-0 me-3 mt-n4 bg-primary-subtle d-none d-md-block rounded-circle opacity-75"
                data-scroll data-scroll-direction="vertical" data-scroll-speed="6">
            </div>
            <div class="container py-12 position-relative">

                <div class="row justify-content-center">
                    <!--Feature column-->
                    <div class="col-12 col-md-4 mb-5 mb-md-0">
                        <div
                            class="flex-center width-6x height-6x rounded-circle border border-primary-subtle lh-1 fw-semiold small mb-4">
                            01
                        </div>
                        <h5 class="mb-3">보유기술1</h5>

                        <p class="mb-0 w-lg-75">
                            Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing
                            industries for previewing layouts and visual mockups.
                        </p>
                    </div>

                    <!--Feature column-->
                    <div class="col-12 col-md-4 mb-5 mb-md-0">
                        <div
                            class="flex-center width-6x height-6x rounded-circle border border-primary-subtle lh-1 fw-semiold small mb-4">
                            02
                        </div>
                        <h5 class="mb-3">보유기술2</h5>
                        <p class="mb-0 w-lg-75">
                            Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing
                            industries for previewing layouts and visual mockups.
                        </p>
                    </div>

                    <!--Feature column-->
                    <div class="col-12 col-md-4">
                        <div
                            class="flex-center width-6x height-6x rounded-circle border border-primary-subtle lh-1 fw-semiold small mb-4">
                            03
                        </div>
                        <h5 class="mb-3">보유기술3</h5>
                        <p class="mb-0 w-lg-75">
                            Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing
                            industries for previewing layouts and visual mockups.
                        </p>
                    </div>
                </div>
            </div>
        </section>

        <section class="position-relative overflow-hidden" data-scroll-section>
            <div class="container py-9 py-lg-11 position-relative z-1">
                <div class="row align-items-stretch">
                    <div class="col-md-10 col-xl-6 order-last">
                        <h3 class="mb-5 display-4 fw-normal mt-n15 mt-lg-0 position-relative ms-lg-n14 z-1" data-scroll
                            data-scroll-direction="vertical" data-scroll-speed="1">
                            간단한 자기 소개 내용입니다. Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        </h3>
                    </div>
                    <div class="col-md-6 order-1 position-relative">
                        <div class="overflow-hidden position-relative" data-scroll data-scroll-direction="vertical"
                            data-scroll-speed="5">
                            <img src="/assets/img/md1.jpg" alt="" class="img-fluid flip-x d-block">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="position-relative" id="projects" data-scroll-section>

            <div class="width-20x height-20x position-absolute end-0 bottom-0 me-3 mt-n4 bg-warning-subtle d-none d-md-block rounded-circle"
                data-scroll data-scroll-direction="vertical" data-scroll-speed="6">
            </div>
            <div class="py-9 py-lg-11 container position-relative z-1">
                <div class="row mb-7">
                    <div class="col-lg-6">
                        <h2 class="display-3 mb-4">교육센터 수행 프로젝트</h2>
                        <p class="lead">
                            Lorem ipsum, dolor sit amet consectetur adipisicing elit.
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 mb-5" data-scroll>
                        <!--Card-->
                        <a href="#!" class="d-block text-reset overflow-hidden position-relative card-hover">
                            <div class="overflow-hidden bg-primary card-reveal-effect">
                                <img src="assets/img/projects/project_1.jpg" alt="" class="img-fluid img-zoom">
                            </div>
                            <div class="card-body pt-4 pb-0">
                                <ul class="list-unstyled mb-0">
                                    <li>
                                        <h5 class="fs-4 mb-1">Awesome title</h5>
                                    </li>
                                    <li><span class="text-body-secondary">Awesome Subtitle</span></li>
                                </ul>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-6 mb-5" data-scroll>
                        <!--Card-->
                        <!--Card-->
                        <a href="#!" class="d-block text-reset overflow-hidden position-relative card-hover">
                            <div class="overflow-hidden bg-primary card-reveal-effect">
                                <img src="assets/img/projects/project_2.jpg" alt="" class="img-fluid img-zoom">
                            </div>
                            <div class="card-body pt-4 pb-0">
                                <ul class="list-unstyled mb-0">
                                    <li>
                                        <h5 class="fs-4 mb-1">Awesome title</h5>
                                    </li>
                                    <li><span class="text-body-secondary">Awesome Subtitle</span></li>
                                </ul>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-6 mb-5 mb-sm-0" data-scroll>
                        <!--Card-->
                        <a href="#!" class="d-block text-reset overflow-hidden position-relative card-hover">
                            <div class="overflow-hidden bg-primary card-reveal-effect">
                                <img src="assets/img/projects/project_3.jpg" alt="" class="img-fluid img-zoom">
                            </div>
                            <div class="card-body pt-4 pb-0">
                                <ul class="list-unstyled mb-0">
                                    <li>
                                        <h5 class="fs-4 mb-1">Awesome title</h5>
                                    </li>
                                    <li><span class="text-body-secondary">Awesome Subtitle</span></li>
                                </ul>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-6" data-scroll>
                        <!--Card-->
                        <a href="#!" class="d-block text-reset overflow-hidden position-relative card-hover">
                            <div class="overflow-hidden bg-primary card-reveal-effect">
                                <img src="assets/img/projects/project_4.jpg" alt="" class="img-fluid img-zoom">
                            </div>
                            <div class="card-body pt-4 pb-0">
                                <ul class="list-unstyled mb-0">
                                    <li>
                                        <h5 class="fs-4 mb-1">Awesome title</h5>
                                    </li>
                                    <li><span class="text-body-secondary">Awesome Subtitle</span></li>
                                </ul>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <section class="position-relative overflow-hidden" data-scroll-section>
            <div class="width-20x height-20x position-absolute start-0 bottom-0 me-3 mt-n4 bg-info-subtle d-none d-md-block rounded-circle"
                data-scroll data-scroll-direction="vertical" data-scroll-speed="6">
            </div>
            <div class="container py-9 py-lg-11 position-relative z-1">
                <div class="row justify-content-around">
                    <div class="col-md-5 col-xl-4 mb-5 mb-md-0">
                        <h4 class="display-3 mb-0" data-scroll data-scroll-direction="vertical" data-scroll-speed="3">
                            수상 내역
                        </h4>
                    </div>
                    <div class="col-md-7 ">
                        <ul class="list-unstyled">
                            <li
                                class="d-flex align-items-center justify-content-between py-3 border-bottom border-secondary">
                                <div class="d-flex align-items-center fw-semibold fs-4">
                                    <span class="d-block me-3">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                            fill="currentColor" class="bx bx-journal-medical text-body-secondary"
                                            viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                d="M8 4a.5.5 0 0 1 .5.5v.634l.549-.317a.5.5 0 1 1 .5.866L9 6l.549.317a.5.5 0 1 1-.5.866L8.5 6.866V7.5a.5.5 0 0 1-1 0v-.634l-.549.317a.5.5 0 1 1-.5-.866L7 6l-.549-.317a.5.5 0 0 1 .5-.866l.549.317V4.5A.5.5 0 0 1 8 4zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z" />
                                            <path
                                                d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z" />
                                            <path
                                                d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z" />
                                        </svg>
                                    </span>
                                    ㅇㅇㅇ 프로그래밍 대회
                                </div>
                                <p class="mb-0 h4">ㅇㅇㅇ</p>
                            </li>
                            <li
                                class="d-flex align-items-center justify-content-between py-3 border-bottom border-secondary">
                                <div class="d-flex align-items-center fw-semibold fs-4">
                                    <span class="d-block me-3">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                            fill="currentColor" class="bx bx-journal-medical text-body-secondary"
                                            viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                d="M8 4a.5.5 0 0 1 .5.5v.634l.549-.317a.5.5 0 1 1 .5.866L9 6l.549.317a.5.5 0 1 1-.5.866L8.5 6.866V7.5a.5.5 0 0 1-1 0v-.634l-.549.317a.5.5 0 1 1-.5-.866L7 6l-.549-.317a.5.5 0 0 1 .5-.866l.549.317V4.5A.5.5 0 0 1 8 4zM5 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z" />
                                            <path
                                                d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z" />
                                            <path
                                                d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z" />
                                        </svg>
                                    </span>
                                    ㅇㅇㅇ 프로그래밍 대회
                                </div>
                                <p class="mb-0 h4">ㅇㅇㅇ</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <!--Footer Start-->
        <jsp:include page="/WEB-INF/views/modules/footer.jsp"/>
         <!--Footer End-->
    </div>
    
    <!-- JavaScript Start -->
    <jsp:include page="/WEB-INF/views/modules/scripts.jsp"/>
     <!-- JavaScript End -->
</body>

</html>