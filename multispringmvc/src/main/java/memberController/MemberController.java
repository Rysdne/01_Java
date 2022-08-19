package memberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member/")
public class MemberController {

//	//@Autowired
//	
//	// 만들어져있지 않아도 된다!
//	//@Autowired(required = false)
//
//	// 모든게 만들어져있다!
//	@Autowired(required = true)
//	VisualService vs;
//
//	@RequestMapping("/membertest")
//	@ResponseBody
//	public String test() {
//		return "membercontroller test";
//	}
//
//	@RequestMapping("/requestname")
//	@ResponseBody
//	public String requestname() {
//		return vs.name();
//	}

	// localhost:8080/member/member
	@RequestMapping("member")
	public String member() {
		return "member";
	}
	
}
