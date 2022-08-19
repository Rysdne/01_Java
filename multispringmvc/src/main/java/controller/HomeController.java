package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home/")
public class HomeController {

//	@RequestMapping("/hometest")
//	@ResponseBody
//	public String test() {
//		return "homecontroller test";
//	}

	// localhost:8080/home/home
	@RequestMapping("home")
	public String home() {
		return "index";
	}

}
