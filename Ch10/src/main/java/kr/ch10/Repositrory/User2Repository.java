package kr.ch10.Repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch10.entity.User1Entity;
import kr.ch10.entity.User2Entity;

@Repository
public interface User2Repository extends JpaRepository<User2Entity, String>{
	
}
