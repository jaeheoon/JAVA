<%@page import="ezen.portfolio.article.dto.Memo"%>
<%@page import="java.util.List"%>
<%@page import="ezen.portfolio.common.dao.DaoFactory"%>
<%@page import="ezen.portfolio.article.dao.MemoDao"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
MemoDao memoDao =  DaoFactory.getInstance().getMemoDao();
List<Memo> list = memoDao.findByAll();
request.setAttribute("list", list);
%>


<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <%-- CSS 파일 포함 --%>
    <jsp:include page="/modules/styles.jsp"/>
    
    <title>Portfolio</title>
</head>

<body>
        <!-- ======================================== Header Start ======================================== -->
        <jsp:include page="/modules/header.jsp"/>
        <!-- ======================================== Header End ======================================== -->

        <%-- 게시글 화면 시작 --%>
        <main>
      	<section class="position-relative">
        <div class="bg-pattern text-primary text-opacity-50 opacity-25 w-100 h-100 start-0 top-0 position-absolute">
        </div>
        <div class="bg-gradientwhite flip-y w-50 h-100 start-50 top-0 translate-middle-x position-absolute"></div>
        <div class="container pt-11 pt-lg-14 pb-9 pb-lg-11 position-relative z-1">
          <div class="row align-items-center justify-content-center">

            <div class="col-md-8 z-2">
              <div class="position-relative">
                <h2>
                  게시글
                </h2>
                <p class="mb-3 w-lg-75">
                  자유롭게 글을 남겨 주세요.
                </p>
                <div class="width-50x pt-1 bg-primary mb-5"></div>

                <form action="/article/articles-action.jsp" method="post" role="form" class="needs-validation mb-5 mb-lg-7" novalidate>
                  <div class="row">
                    <div class="mb-3 text-end">
                      <label class="form-label">2023-05-05</label>
                      <textarea class="form-control" name="content" placeholder="로그인 하여야 게시글을 입력할 수 있습니다...." required
                        <c:if test="${empty loginMember}">disabled</c:if>></textarea>
                    </div>

                    <div class="d-md-flex justify-content-end align-items-center mb-5">
                      <input type="submit" value="글 남기기" id="sendBtn" class="btn btn-warning btn-sm">
                    </div>
                </form>

                <div class="px-4  py-3 position-relative" data-aos="fade-up">
                  
                  <ul class="list-group">
                    
                    <li class="list-group-item">
                      <div class="mb-3 text-end">
                        <label class="fs-6">김철수 | 2023-05-05 12:00</label>
                        <p class="form-control text-start bg-gray-200" disabled>좋은글 감사합니다. 잘해 봅시다
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque aliquam veritatis
                          asperiores. Ut iusto quaerat officia.
                        </p>
                      </div>
                    </li>

                    <li class="list-group-item">
                      <div class="mb-3 text-end">
                        <label class="fs-6">김영희 | 2023-05-05 12:00</label>
                        <p class="form-control text-start bg-gray-200" disabled>
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Eaque aliquam veritatis
                          asperiores. Ut iusto quaerat officia.
                        </p>
                      </div>
                    </li>
                    
                  </ul>

                  <!-- pagination-->
                  <nav class="mt-3">
                    <ul class="pagination justify-content-center">
                      <li class="page-item disabled">
                        <a class="page-link" href="#" aria-label="Previous">
                          <span aria-hidden="true">&laquo;</span>
                        </a>
                      </li>
                      <li class="page-item active"><a class="page-link" href="#">1</a></li>
                      <li class="page-item"><a class="page-link" href="#">2</a></li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                          <span aria-hidden="true">&raquo;</span>
                        </a>
                      </li>
                    </ul>
                  </nav>

                </div>

              </div>


            </div>
          </div>
        </div>
      </section>
    </main>
        
        <%-- 게시글 화면 종료 --%>
        
    
    <!-- JavaScript Start -->
    <jsp:include page="/modules/scripts.jsp"/>
     <!-- JavaScript End -->
</body>

</html>