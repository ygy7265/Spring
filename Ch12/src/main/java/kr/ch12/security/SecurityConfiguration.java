package kr.ch12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurityConfiguration  {
	@Autowired
	private SecurityUserService service;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 인가 설정
		http
		.authorizeHttpRequests(
			authorizeHttpRequests -> 
			authorizeHttpRequests
			.requestMatchers("/","/user/**").permitAll()
			.requestMatchers("/admin/**").hasAuthority("ADMIN")
			.requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER")
			.anyRequest().permitAll()
		)
		//토큰방식으로 로그인처리하기때문에 품방식 비활성
		.formLogin(config -> config.loginPage("/user/login")
									.defaultSuccessUrl("/")
									.usernameParameter("uid")
									.passwordParameter("pass")
		)
		.logout(config -> config.logoutUrl("/user/logout")
								.logoutSuccessUrl("/logout")
								
		)
		.oauth2Login(config -> config.loginPage("/user/login")
									 .defaultSuccessUrl("/")
		)
		// 사이트 위변조 방지 해제
		.csrf(CsrfConfigurer::disable)
		//http인증방식 비활성
		.userDetailsService(service);// 사용자 인증처리 컴포넌트 등록
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
}
