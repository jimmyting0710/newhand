package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ThisService;


@CrossOrigin
@Controller
public class FindController {

	@Autowired
	ThisService service;

	@RequestMapping("/find")
	public String name(Model model, HttpServletRequest request) {
		String ename = request.getParameter("ename");
//		System.out.println();
		if (ename.equals("all")|| ename.equals("ALL") ) {
			List<Map<ThisService, Object>> findall = service.findallname(ename);
			model.addAttribute("findename", findall);
		} else {
			List<Map<ThisService, Object>> findename = service.findename(ename);
			model.addAttribute("findename", findename);
		}
		return "find";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, HttpServletRequest request) {
		String ename = request.getParameter("ename");
		service.delete(ename);
		return "index";
	}
	@RequestMapping("/update")
	public String update(Model model, HttpServletRequest request) {
		String ename = request.getParameter("ename");
		String phone = request.getParameter("phone");
		service.update(ename,phone);
		return "index";
	}
}
