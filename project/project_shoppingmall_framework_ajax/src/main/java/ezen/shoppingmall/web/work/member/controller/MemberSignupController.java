package ezen.shoppingmall.web.work.member.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.member.dto.Member;
import ezen.shoppingmall.domain.member.service.MemberService;
import ezen.shoppingmall.web.mvc.controller.HttpController;

/**
 * 회원 가입 화면 및 가입 요청 처리 세부 컨트롤러
 * /member/signup
 */
public class MemberSignupController implements HttpController {
	
	private MemberService memberService =  ServiceFactory.getInstance().getMemberService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		String viewName = null;
		// 회원 가입 화면 요청 (GET)
		if(request.getMethod().equalsIgnoreCase("get")) {
			viewName = "member/signup";
		}else { // 회원 가입 요청 (POST)
			viewName = "member/signup-result";
			String name = paramMap.get("name");
			String id = paramMap.get("id");
			String passwd = paramMap.get("passwd");
			String email = paramMap.get("email");

			Member member = new Member(id, passwd, name, email, null);
			// 반환받은 member 객체에는 가입일자 정보 포함
			member = memberService.registerMember(member);
			// 모델에 회원정보 저장
			model.put("member", member);
		}
		return viewName;
	}
}










