package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {

		// config.xml 파일로 bean 생성
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/config.xml");

		// Print p = new APrint();
		Print p = (Print) ctx.getBean("aprint");
		p.print1();

	}

}
