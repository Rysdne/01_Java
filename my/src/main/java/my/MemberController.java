package my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// localhost:8080/login/login
@Controller
@RequestMapping("/login/")
public class MemberController {

	//@RequestMapping("/login/login")
	@RequestMapping("login")
	public String login() {

		return "login";
	}

}
