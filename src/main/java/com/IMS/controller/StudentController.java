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

import com.IMS.model.Student;
import com.IMS.model.Search;
import com.IMS.service.StudentService;
import com.IMS.util.PaginatorHelper;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;

	@RequestMapping(value= "", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@ModelAttribute(value = "search") Search search,Model model, 
			@PageableDefault(value = PaginatorHelper.DEFAULT_PAGINATION_SIZE, page = 0) Pageable pageable) {
		List<Student> students = service.listSearched(search);
		Page<Student> page=PaginatorHelper.pagiableList(students, pageable);
		model.addAttribute("students", students);
		model.addAttribute("page", page);
		return "student/list";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		Student student = new Student();
		
	    model.addAttribute("student", student);
		return "student/add";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("student") Student student) {
	    service.save(student);
	     
	    return "redirect:/student";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditProductPage(Model model,@PathVariable(name = "id") int id) {
	    Student student = service.get(id);
	    
	    model.addAttribute("student", student);
	    
	    return "student/add";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(Model model,@PathVariable(name = "id") int id) {
	    service.delete(id);
	    
	    return "redirect:/student";
	}
}
