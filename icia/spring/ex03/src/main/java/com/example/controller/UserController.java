package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user/list")
	public String list() {
		return "/user/list";
	}
	
	// �����޽���
	@RequestMapping("/user/read/{uid}")
	public String read(Model model, @PathVariable String uid) {
		model.addAttribute("uid", uid);
		return "/user/read";
	}

	// �����޽���
	@RequestMapping("/user/read1/{uid}")
	public String read1(Model model, @PathVariable String uid) {
		model.addAttribute("uid", uid);
		return "/user/read1";
	}

}
