package sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2023/09/18 
 * 이름 : 윤경엽
 * 내용 : 
 */
public class IocMain {
	public static void main(String[] args) {
		
		// 스프링 컨텍스트(컨테이너) 생성
		ApplicationContext ctx= new GenericXmlApplicationContext("application.xml");
		LgTV lg = (LgTV) ctx.getBean("lg");
		lg.powerOn();
		lg.powerOff();
		lg.soundUp();
		lg.soundDown();
	}
}
