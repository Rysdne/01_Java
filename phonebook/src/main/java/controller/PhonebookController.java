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
public class PhonebookController {

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

	@RequestMapping("/insert")
	public ModelAndView insert(PhonebookVO pb) {
		int result = service.insert(pb);
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

}