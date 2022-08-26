package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.PhonebookServiceInter;
import vo.PhonebookVO;

@Controller
public class MemoController {

	@Autowired
	PhonebookServiceInter service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.getList());
		mv.setViewName("list");
		return mv;
	}

	@RequestMapping("/find")
	public ModelAndView list(String search) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.find(search));
		mv.setViewName("list");
		return mv;
	}

//	// Form 처리 시 사용
//	@RequestMapping("/insertProc")
//	public String insert(PhonebookVO pb) {
//		int result=service.insert(pb);
//		return "index";
//		
//	}

	// AJAX 처리 시 사용
	// AJAX로 URL이 호출되기 때문에 페이지 이동 없이 결과로 돌려줌
	@RequestMapping("/insert")
	public ModelAndView insert(PhonebookVO pb) {

		// DB 입력 작업
		int result = service.insert(pb);

		// 전체 리스트 요청
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.getList());
		mv.setViewName("list");
		return mv;

	}

	@RequestMapping("/findOne")
	public ModelAndView findOne(int idx) {
		System.out.println(service.findOne(idx).toString());
		ModelAndView mv = new ModelAndView();
		mv.addObject("phonebook", service.findOne(idx));
		mv.setViewName("findOne");
		return mv;
	}

	// Form 처리 시 사용
	@RequestMapping("/delete")
	public ModelAndView delete(int idx) {
		ModelAndView mv = new ModelAndView();
		service.delete(idx);
		mv.addObject("list", service.getList());
		mv.setViewName("list");
		return mv;

	}

	@RequestMapping("/updateForm")
	public ModelAndView updateForm(int idx) {
		System.out.println(service.findOne(idx).toString());
		ModelAndView mv = new ModelAndView();
		mv.addObject("phonebook", service.findOne(idx));
		mv.setViewName("updateForm");
		return mv;
	}

	@RequestMapping("/updateProc")
	public ModelAndView updateProc(int idx, String name, String hp, String memo) {
		service.update(idx, name, hp, memo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.getList());
		mv.setViewName("list");
		return mv;
	}

	@RequestMapping("/form")
	public String form() {
		return "form";
	}

	// 문자열을 돌려줄때(?)
	@ResponseBody
	@PostMapping(value = "/formProc")
	public String home(@RequestBody String json) {
		System.out.println(json);
		return json;
	}
	
}