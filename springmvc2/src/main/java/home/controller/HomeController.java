package home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();

		// 페이지 정보 기입
		mv.addObject("page", "home/main.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();

		// 페이지 정보 기입
		mv.addObject("page", "home/main.jsp");
		mv.setViewName("index");
		return mv;
	}

//	@ResponseBody
//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}

}
