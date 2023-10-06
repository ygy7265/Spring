package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.ch10.DTO.User2DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "USER2")
public class User2Entity {
	
	@Id
	private String id;
	private String name;
	private String hp;
	private int age;
	public User2Entity() {
	        
	}
	
	public User2DTO toDTO() {
		return User2DTO.builder()
				.id(id)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
				
				
	}
}
