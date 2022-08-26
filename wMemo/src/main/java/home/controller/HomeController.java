package home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();

		if (req.getSession().getAttribute("id") == null) {
			mv.addObject("content", "login/login.jsp");
		} else {
			mv.addObject("content", "home/main.jsp");
		}
		mv.setViewName("index");
		return mv;
	}
}
