package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

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

}
