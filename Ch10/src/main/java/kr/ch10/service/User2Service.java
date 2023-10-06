package kr.ch10.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.ch10.DTO.User2DTO;
import kr.ch10.Repositrory.User2Repository;
import kr.ch10.entity.User1Entity;
import kr.ch10.entity.User2Entity;

@Service
public class User2Service {
	
	@Autowired
	private User2Repository repo;
	
	public void insertUser2(User2DTO dto) {
		User2Entity user2 = dto.toEntity();
		repo.save(user2);
		
	}
	public User2DTO selectUser2(String id) {
		Optional<User2Entity> result = repo.findById(id);
		User2DTO dto = result.get().toDTO();
		
		return dto;
	}
	public List<User2DTO> selectUser2s() {
		 return repo.findAll()
				 .stream()
				 .map(entity -> User2DTO.builder()
						 .id(entity.getId())
						 .name(entity.getName())
						 .hp(entity.getHp())
						 .age(entity.getAge())
						 .build()
						 )
				 .collect(Collectors.toList());
		 
	}
	public void updateUser2(User2DTO dto) {
		User2Entity user2 = dto.toEntity();
		repo.save(user2);
	}
	public void deleteUser2(String id) {
		
		repo.deleteById(id);
		
	}
	
}
