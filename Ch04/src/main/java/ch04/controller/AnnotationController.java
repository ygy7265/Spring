package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch04.dto.ModelDTO;

@Controller
public class AnnotationController {

	@RequestMapping(value="/annotation/param",method = RequestMethod.GET)
	public String param() {
		return "/annotation/param";
	}
	
	@GetMapping("/annotation/model")
	public String model() {
		return "/annotation/model";
	}
	@RequestMapping(value="/annotation/param1",method = RequestMethod.POST)
	public String param1(@RequestParam("uid") String uid, Model model) {
		System.out.println("uid =" + uid);
		model.addAttribute("uid",uid);
		return "/result/param";
	}
	@PostMapping(value="/annotation/param2")
	public String param2(Model model,@RequestParam("uid")String uid,String name) {
		System.out.println("uid = " + uid);
		System.out.println("name = " + name);
		
		model.addAttribute("uid",uid);
		model.addAttribute("name",name);
		return "/result/param";
	}
	@RequestMapping(value="/annotation/param3",method = RequestMethod.POST)
	public String param3(String uid,String hp, String name,int age,Model model) {
		
		model.addAttribute("uid",uid);
		model.addAttribute("hp",hp);
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "/result/param";
	}
	
	@PostMapping("/annotation/model1")
	public String model1(@ModelAttribute ModelDTO dto) {
		return "/result/model";
	}
	@PostMapping("/annotation/model2")
	public String model2(@ModelAttribute("mo")ModelDTO dto) {
		return "/result/model";
	}
	@PostMapping("/annotation/model3")
	public String model3(ModelDTO dto) {
		return "/result/model";
	}

}
