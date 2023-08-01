package ezen.network.crawling;

import java.io.IOException;
import java.util.Iterator;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
/*
 * Crawler
 * 크롤링(crawling) 혹은 스크레이핑(scraping)은 웹(html)페이지를 읽어와서
 * 필요한 데이터를 추출해 내는 작업
 * 크롤링에 필요한 외부 라이브러리를 https://jsoup.org 에서 다운로드
 * src 폴더 밑에 lib 폴더 작성하고 복사 후 Build Path(클래스 패스) 추가 필요
 */
public class Crawling {

	public static void main(String[] args) {
//		cgv 사이트에서 상영 예정작 추출하여 목록 출력하기
		String url = "https://www.cgv.co.kr/";
		
		Document document = null;
		try {
//			웹서버 연결 및 GET 방식 요청으로 HTML 수신/파싱
			document = Jsoup.connect(url).get();
//			System.out.println(document);
			
//			select() 메소드를 이용하여 html의 특정 요소를 읽어온다
			Element titleElement =  document.selectFirst("#btnReserMovie");
//			System.out.println(titleElement);
			System.out.println("======== CGV" + titleElement.text() + " ========");
			
			Elements list = document.select("div.movie_info_wrap");
			Iterator<Element> iter = list.iterator();
			while (iter.hasNext()) {
				Element element = iter.next();
				System.out.println("-" + element.child(0).text() + "("+element.child(2).text()+")");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
