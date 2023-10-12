package kr.co.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    private String uid;
    private String pass;
    @Column(name = "nick", unique = true)
    private String nick;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "hp", unique = true)
    private String hp;
    private String role;
    private String zip;
    private String addr1;
    private String addr2;
    private String regip;
    private String regDate;
    private String leaveDate;
    private String age;


}
