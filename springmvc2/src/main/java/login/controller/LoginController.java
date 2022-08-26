package login.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import login.service.LoginServiceInter;
import member.vo.MemberVO;

@Controller
public class LoginController {

	@Autowired
	LoginServiceInter service;
	int timeout = 10 * 60;

	@RequestMapping("login")
	// @RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("page", "login/login.jsp");
		mv.setViewName("index");
		// ViewResolver가 동작하여 WEB-INF/view/login/ + ViewName이 적용됨
		// 해당 폴더에 index.jsp 파일이 위치해야 함
		// 그러나 이렇게 되면 모든 폴더에 index.jsp가 위치해야 함
		// 각기 다른 index를 사용해야 할 경우에는 위처럼 하면 됨
		// 다 같은 index를 사용할 경우엔 ViewResolver의 prefix 부분을 view까지만으로 설정해도 될 듯

		return mv;
	}
//	// 중간에 값을 입력하는 상황이 아닌 경우 ModelAndView가 아닌 String으로 줘도 됨
//	@RequestMapping("login")
//	public String login() {
//		return "login";
//	}

	@RequestMapping("loginProc")
	public ModelAndView loginProc(MemberVO member, HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();
		boolean result = service.login(member);
		if (result == true) {
			req.getSession().setAttribute("id", member.getId());
			req.getSession().setMaxInactiveInterval(timeout);
			// 어떤 ip, 로그인 시간
			System.out.println("로그인 ip:" + req.getRemoteAddr());
			System.out.println("로그인 시간:" + req.getSession().getCreationTime());
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println("로그인 시간:" + fmt.format(req.getSession().getCreationTime()));
			// 세션시간 전달
			mv.addObject("sessiontime", req.getSession().getMaxInactiveInterval());
			System.out.println("로그인 성공");
		} else {
			// 로그인 페이지 이동
			mv.addObject("page","login/login.jsp");
			System.out.println("로그인 실패");
		}
		mv.setViewName("index");
		return mv;
	}

	public void logout(HttpServletRequest req) {
		// 세션해제
		req.getSession().invalidate();
		// 로그아웃시간
		System.out.println("로그아웃 시간:" + req.getSession().getLastAccessedTime());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("로그아웃 시간:" + fmt.format(req.getSession().getLastAccessedTime()));
	}

}
