package kr.ch12.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MainCotroller {
	
	@GetMapping(value = {"/","/index"})
	public String index() {
		return "/index";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	
	 @GetMapping(value = "/kakao")
	    public String kakaoOauthRedirect(@RequestParam String code) {
	        return "카카오 로그인 인증 완료, code : " + code;
	 }
}
