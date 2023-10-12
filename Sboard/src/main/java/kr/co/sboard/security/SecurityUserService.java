package kr.co.security;

import kr.co.entity.UserEntity;
import kr.co.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SecurityUserService implements UserDetailsService{
	 private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user =  repo.findById(username).orElseThrow(()->new UsernameNotFoundException(username + "NotFound"));
		logger.info("user = " + user);
		UserDetails userDetails = MyUserDetails.builder()
									.user(user)
									.build();
		return userDetails;
	}
	
}
