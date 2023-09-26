package kr.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ch07.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MainController {
	
	@GetMapping(value = {"/","/index"})
	public String index(Model model) {
		
		String str1="스프링부트";
		String str2 = "타임리프";
		
		User1DTO user1 = new User1DTO();
		User1DTO user2 = new User1DTO("A101","장보고","114",26);
		User1DTO user3 = null;
		User1DTO user4 = User1DTO.builder()
						.uid("A103")
						.name("장보고")
						.hp("115")
						.age(26)
						.build();
		
		List<User1DTO> list = new ArrayList<>();
		
		list.add(new User1DTO("b101","김군","211",40));
		list.add(new User1DTO("b102","이군","212",41));
		list.add(new User1DTO("b103","강군","213",42));
		list.add(new User1DTO("b104","윤군","214",43));
		user1.setUid("A102");
		user1.setName("김춘추");
		user1.setHp("112");
		user1.setAge(25);
		
		model.addAttribute("user1",user1);
		model.addAttribute("user2",user2);
		model.addAttribute("user3",user3);
		model.addAttribute("user4",user4);
		model.addAttribute("list",list);
		model.addAttribute("str1",str1);
		
		log.info(user1.toString());
		log.info(user2.toString());
		log.debug(user4.toString());
		return "/index";
		
	}
	
	@GetMapping("/include")
	public String include(String name, int age) {
		
		log.info("name"+name);
		log.info("age"+age);
		return "/include";
	}
	@GetMapping("/layout")
	public String layout() {
		return "/layout";
	}
}
