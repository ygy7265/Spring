package sub01;

/*
 * 날짜 : 2023/09/18 
 * 이름 : 윤경엽
 * 내용 : Spring IoC 실습
 * 
 * IoC
 * -Inversion of Control(제어의 역전)
 **/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		if(ctx != null) {
			Hello hello = (Hello) ctx.getBean("hello");
			Welcome welcome= (Welcome) ctx.getBean("welcome");
			Greeting greeting = (Greeting) ctx.getBean("greeting");
			System.out.println("Hello Spring Freamwork!");
			
			hello.show();
			welcome.show();
			greeting.show();
		}
		

	}

}
