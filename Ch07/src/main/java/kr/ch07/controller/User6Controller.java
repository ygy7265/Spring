package kr.ch07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch07.dto.User6DTO;
import kr.ch07.mapper.User6Mapper;
import kr.ch07.service.User6Service;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class User6Controller {
	
	 private final User6Service service; // 생성자 주입을 위한 final 필드

    @Autowired
    public User6Controller(User6Service service) {
        this.service = service;
    }
	@GetMapping("/user6/register")
	public String register() {
		return "/user6/register";
	}
	@PostMapping("/user6/register")
	public String register(User6DTO dto) {
		service.insertUser6(dto);
		log.info("Insert controller"+dto.toString());
		return "redirect:/user6/list";
	}
	
	@GetMapping("/user6/modify")
	public String modify(Model model,String uid) {
		User6DTO dto = service.selectUser6(uid);
		model.addAttribute("dto",dto);
		return "/user6/modify";
	}
	@PostMapping("/user6/modify")
	public String modify(User6DTO dto) {
		service.updateUser6(dto);
		return "redirect:/user6/list";
	}
	
	
	@GetMapping("/user6/list")
	public String list(Model model) {
		 
		List<User6DTO> list = service.selectUser6s();
		
		 model.addAttribute("list",list);
		return "/user6/list";
	}
	
	@GetMapping("/user6/delete")
	public String delete(String uid) {
		service.deleteUser6(uid);
		return "redirect:/user6/list";
	}
}
