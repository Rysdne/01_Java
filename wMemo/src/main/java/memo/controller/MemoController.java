package memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import memo.service.MemoServiceInter;
import memo.vo.MemoVO;

@Controller
public class MemoController {

	@Autowired
	MemoServiceInter MemoService;
	
	@RequestMapping("/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("content","/memo/create.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/createProc")
	public ModelAndView createProc(MemoVO memo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("content","/memo/create.jsp");
		mv.setViewName("index");
		return mv;
	}

	
	
}
