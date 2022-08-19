package home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index() {

		String id = null;
		ModelAndView mv = new ModelAndView();
		mv.addObject("content", "home/main.jsp");
		mv.setViewName("index");

		return mv;
		
	}
}
