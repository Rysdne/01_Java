package di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("di/annotation/setting.xml");
		
		Student student=(Student)factory.getBean("student");
		
		System.out.println(student.toString());

	}

}
