package ezen.shoppingmall.web.work.article.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ezen.shoppingmall.domain.article.dto.Memo;
import ezen.shoppingmall.domain.article.service.ArticleService;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.web.mvc.controller.HttpController;
import ezen.shoppingmall.web.mvc.controller.RestController;

/**
 * 댓글 처리 세부 컨트롤러 
 * /article
 */
public class ArticleReplyController implements RestController {

//	private ArticleService articleService = ServiceFactory.getInstance().getArticleService();

	@Override
	public void process(Map<String, String> paramMap, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			// 댓글 테이블이 없는 관계로 정적 테스트
			// List<Reply> list = new ArrayList<Reply>();
			List<Memo> list = new ArrayList<Memo>();
			list.add(new Memo(1, "댓글테스트입니다1..", "2023-07-20 00:00", null, null));
			list.add(new Memo(2, "댓글테스트입니다2..", "2023-07-20 00:00", null, null));
			list.add(new Memo(3, "댓글테스트입니다3..", "2023-07-20 00:00", null, null));
			list.add(new Memo(4, "댓글테스트입니다4..", "2023-07-20 00:00", null, null));
			list.add(new Memo(5, "댓글테스트입니다5..", "2023-07-20 00:00", null, null));
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonList = objectMapper.writeValueAsString(list);
			out.println(jsonList);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
