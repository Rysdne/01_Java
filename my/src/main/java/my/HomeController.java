package my;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// 순수자바의 @Component 역할(?), Bean 생성
@Controller
public class HomeController {

	// RequestMapping : Bean의 id 역할
	// ㄴ이걸 사용할라면 스캔한다는 명령을 내려줘야 함
	@RequestMapping("/test1")
	public ModelAndView test1() {
		ModelAndView mv = new ModelAndView();

		// 얘네는 dispatcher-servlet.xml 파일에 viewResolver가 설정되지 않았을 경우에 사용
		// mv.addObject("data","홍길동");
		// mv.setViewName("/WEB-INF/test1.jsp");

		// viewResolver가 설정되었을 경우 사용
		mv.setViewName("test1");

		return mv;
	}

	@RequestMapping("/test2")
	public String test2() {

		return "test2";
		// test2.jsp 파일을 dispatch-servlet으로 보냄
		// ㄴ결국 /WEB-INF/view/test2.jsp 파일 접근
		// setViewName 역할도 하게 됨

	}

	@GetMapping("/test3")
	public String test3() {

		return "test3";

	}

	// localhost:8080/test4?page=10
	// url 자체로 데이터를 받아 사용하는 방법
	@RequestMapping("/test4")
	public ModelAndView test4(String page) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("page", page);
		mv.setViewName("test4");

		return mv;
	}

	// request로 내용을 들여와서 addObject로 전달할 수 있음
	@RequestMapping("/test5")
	public ModelAndView test5(HttpServletRequest request) {

		String page = request.getParameter("page");

		ModelAndView mv = new ModelAndView();
		mv.addObject("page", page);
		mv.setViewName("test5");

		return mv;
	}

	@RequestMapping("/test6")
	@ResponseBody
	public String test6() {
		return "<h1>test6</h1>";
	}

	// http://localhost:8080/test7?title=SpringTitle&content=Contents
	@RequestMapping("/test7")
	@ResponseBody
	public String test7(String title, String content) {
		return String.format("<h1>%s</h1><br><p>%s</p>", title, content);
	}

}
