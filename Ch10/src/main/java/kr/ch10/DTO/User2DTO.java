package kr.ch10.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kr.ch10.entity.User2Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User2DTO {

	private String id;
	private String name;
	private String hp;
	private int age;
	
	
	public User2Entity toEntity() {
		return User2Entity.builder()
				.id(id)
				.name(name)
				.hp(hp)
				.age(age)
				.build();
	}
}
