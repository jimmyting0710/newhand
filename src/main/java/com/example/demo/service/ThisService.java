package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ThisIsRepository;

@Service
public class ThisService {
	@Autowired
	ThisIsRepository repository;
	
	public void save(String ename, String phone) {
//		System.out.println(ename+phone);
		repository.saveid(ename,phone);
		
	}

	public List<Map<ThisService, Object>> findename(String ename) {
		
		return repository.findename(ename);
	}

	public List<Map<ThisService, Object>> findallname(String all) {
		// TODO Auto-generated method stub
		return repository.findAllname(all);
	}

	public void delete(String ename) {
		repository.deletebyename(ename);
	}

	public void update(String ename, String phone) {
		repository.update(ename,phone);
	}

	
	
}
