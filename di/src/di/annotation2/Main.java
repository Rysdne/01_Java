package di.annotation2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("di/annotation2/setting.xml");
		
		// @Component -> getBean("student");
		// student로 사용할 수 잇는 이유는 클래스명의 앞 대문자를 소문자로 변환하여 인식하기 때문
		// 이름을 부여하고 싶을 땐 Component에 value값을 Main 클래스의 getBean값과 일치시키면 됨
		// Student student=(Student)factory.getBean("student");
		Student student=(Student)factory.getBean("s");
		
		System.out.println(student.toString());

	}

}
