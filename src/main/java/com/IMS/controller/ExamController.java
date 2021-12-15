
package com.IMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.IMS.model.Exam;
import com.IMS.model.eSearch;
import com.IMS.service.ExamService;
import com.IMS.util.PaginatorHelper;

@Controller
@RequestMapping("/exam")
public class ExamController {
	
	@Autowired
	private ExamService service;

	@RequestMapping(value= "", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@ModelAttribute(value = "search") eSearch search,Model model, 
			@PageableDefault(value = PaginatorHelper.DEFAULT_PAGINATION_SIZE, page = 0) Pageable pageable) {
		List<Exam> exams = service.listSearched(search);
		Page<Exam> page=PaginatorHelper.pagiableList(exams, pageable);
		model.addAttribute("exams", exams);
		model.addAttribute("page", page);
		return "exam/elist";
	}
	
	@RequestMapping("/eadd")
	public String add(Model model) {
		Exam exam = new Exam();
		
	    model.addAttribute("exam", exam);
		return "exam/eadd";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("exam") Exam exam) {
	    service.save(exam);
	     
	    return "redirect:/exam";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditProductPage(Model model,@PathVariable(name = "id") int id) {
	    Exam exam = service.get(id);
	    
	    model.addAttribute("exam", exam);
	    
	    return "exam/eadd";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(Model model,@PathVariable(name = "id") int id) {
	    service.delete(id);
	    
	    return "redirect:/exam";
	}
}

