package kr.ch11.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.ch11.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = -5532680704133363159L;
	
	private UserEntity user;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		//계정이 갖는 비밀번호
		return user.getPass();
	}

	@Override
	public String getUsername() {
		//계정이 갖는 아이디
		return user.getUid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 계정 비밀번호 만료 여부
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 활성화 여부
		return true;
	}

}
