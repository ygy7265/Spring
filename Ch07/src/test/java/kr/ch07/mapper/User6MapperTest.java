package kr.ch07.mapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import kr.ch07.controller.MainController;
import kr.ch07.controller.User6Controller;
import kr.ch07.dto.User1DTO;
import kr.ch07.dto.User6DTO;
import kr.ch07.service.User6Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest(User6Controller.class)
public class User6MapperTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
    private User6Service user6Service;

    @MockBean
    private User6Mapper user6Mapper;

    @Test
	public void insertUser6() throws Exception {
		mvc
		.perform(post("/user6/register")
				.param("uid", "test04")
				.param("name", "김춘추")
				.param("birth", "1994-08-13")
				.param("gender", "2")
				.param("addr", "서울")
				.param("age", "25")
				.param("hp", "010-9283-2322")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("/user6/register"))
		.andDo(print());
	};
	@Test
	public void selectUser6() throws Exception {
		mvc
		.perform(post("/user6/modify").param("uid", "test02"))
		.andExpect(status().isOk())
		.andExpect(view().name("/user6/modify"))
		.andDo(print());
	};
	@Test
	public void selectUser6s() throws Exception {
		mvc
		.perform(get("/user6/list"))
		.andExpect(status().isOk())
		.andExpect(view().name("/user6/list"))
		.andDo(print());
	};
	@Test
	public void updateUser6() throws Exception {
		mvc
		.perform(post("/user6/modify")
				.param("name", "김춘추")
				.param("birth", "1994-08-13")
				.param("gender", "2")
				.param("addr", "서울")
				.param("age", "25")
				.param("hp", "010-9283-2322")
				)
		.andExpect(status().isOk())
		.andExpect(view().name("/user6/modify"))
		.andDo(print());
	};
	@Test
	public void deleteUser6() throws Exception {
		mvc
		.perform(get("/user6/delete").param("uid", "test03"))
		.andExpect(status().isOk())
		.andExpect(view().name("/user6/list"))
		.andDo(print());
	};

}
