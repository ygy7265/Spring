package kr.ch12.security;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ch12.entity.UserEntity;
import kr.ch12.repository.UserRepository;

@Service
public class SecurityUserService implements UserDetailsService{
	 private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	@Autowired
	private kr.ch12.repository.UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user =  repo.findById(username).get();
		logger.info("user = " + user);
		UserDetails userDetails = MyUserDetails.builder()
									.user(user)
									.build();
		return userDetails;
	}
	
}
