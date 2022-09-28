package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.ThisIsEntity;
import com.example.demo.service.ThisService;


@CrossOrigin
@RestController

public class AddController {
	@Autowired
	ThisService service;

	@RequestMapping("/add")
	public String adduser(@RequestParam(value = "ss", required = false) String addjson) {
//		System.out.println("3333");
		JSONObject object = JSONObject.parseObject(addjson);
		String ename = object.getString("ename");
		String phone = object.getString("phone");
		service.save(ename, phone);

		String jsonStr = "{\"success\":\"OK\"}";

		return jsonStr;

	}
}
