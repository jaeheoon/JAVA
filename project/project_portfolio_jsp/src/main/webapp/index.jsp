<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Theory by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<%-- CSS 파일 포함 --%>
		<jsp:include page="/modules/styles.jsp"/>
		<!-- ======================================== Header Start ======================================== -->
        <jsp:include page="/modules/header.jsp"/>
        <!-- ======================================== Header End ======================================== -->
	</head>
	<body>
	

		<!-- Banner -->
			<section id="banner">
				<h1>Welcome to Portfolio</h1>
				<p>A free responsive HTML5 website template by TEMPLATED.</p>
			</section>

		<!-- One -->
			<section id="one" class="wrapper">
				<div class="inner">
					<h3>보유 기술</h3>
					<div class="flex flex-4">
						<article>
							<header>
								<h3>1. Java <span class="fab fab fa-java"></span></h3>
							</header>
						</article>
						<article>
							<header>
								<h3>2. PL/SQL <span class="fas fa-database"></span></h3>
							</header>
						</article>
						<article>
							<header>
								<h3>3. HTML-5 <span class="fab fa-html5"></span> <span class="fab fa-bootstrap"></span></h3>
							</header>
						</article>
						<article>
							<header>
								<h3>4. css <span class="fab fa-css3-alt"></span></h3>
							</header>
						</article>
						<article>
							<header>
								<h3>5. JavaScript <span class="fa-brands fa-square-js"></span></h3>
							</header>
						</article>
						<article>
							<header>
								<h3>6. JSP <span class="far fa-window-maximize"></span></h3>
							</header>
						</article>
					</div>
				</div>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper style1 special">
				<div class="inner">
					<header>
						<h2>자기소개</h2>
						<p>Semper suscipit posuere apede</p>
					</header>
					<div class="row">
						<div class="box person 3u 12u$(medium)">
							<div class="image round">
								<img src="assets/images/pic05.jpg" alt="Person 1" />
							</div>
							<h3>홍재헌</h3>
							<h3>HongJaeHeon</h3>
							<p>Engineer</p>
						</div>
						<div class="1u 12u$(medium)">      &nbsp;</div>
						<div class="box person 8u 12u$(medium)">
							<p>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
								자기소개 내용입니다<br>
							</p>
							</div>
					</div>
				</div>
			</section>

		<!-- Three -->
			<section id="three" class="wrapper special">
				<div class="inner">
					<header class="align-center">
						<h2>Project</h2>
						<p>프로젝트 구현 목록 </p>
					</header>
					<div class="flex flex-2">
						<article>
							<div class="image fit">
								<img src="assets/images/pic01.jpg" alt="Pic 01" />
							</div>
							<header>
								<h3>Praesent placerat magna</h3>
							</header>
							<p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor lorem ipsum.</p>
							<footer>
								<a href="#" class="button special">More</a>
							</footer>
						</article>
						<article>
							<div class="image fit">
								<img src="assets/images/pic02.jpg" alt="Pic 02" />
							</div>
							<header>
								<h3>Fusce pellentesque tempus</h3>
							</header>
							<p>Sed adipiscing ornare risus. Morbi est est, blandit sit amet, sagittis vel, euismod vel, velit. Pellentesque egestas sem. Suspendisse commodo ullamcorper magna non comodo sodales tempus.</p>
							<footer>
								<a href="#" class="button special">More</a>
							</footer>
						</article>
					</div><br>
					<div class="flex flex-2">
						<article>
							<div class="image fit">
								<img src="assets/images/pic01.jpg" alt="Pic 01" />
							</div>
							<header>
								<h3>Praesent placerat magna</h3>
							</header>
							<p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor lorem ipsum.</p>
							<footer>
								<a href="#" class="button special">More</a>
							</footer>
						</article>
						<article>
							<div class="image fit">
								<img src="assets/images/pic02.jpg" alt="Pic 02" />
							</div>
							<header>
								<h3>Fusce pellentesque tempus</h3>
							</header>
							<p>Sed adipiscing ornare risus. Morbi est est, blandit sit amet, sagittis vel, euismod vel, velit. Pellentesque egestas sem. Suspendisse commodo ullamcorper magna non comodo sodales tempus.</p>
							<footer>
								<a href="#" class="button special">More</a>
							</footer>
						</article>
					</div><br>
				</div>
			</section>

		<!--Footer Start-->
        <jsp:include page="/modules/footer.jsp"/>
         <!--Footer End-->

		<div class="copyright">
			Site made with: <a href="https://templated.co/">TEMPLATED.CO</a>
		</div>

		<!-- JavaScript Start -->
   		<jsp:include page="/modules/scripts.jsp"/>
    	<!-- JavaScript End -->

	</body>
</html>