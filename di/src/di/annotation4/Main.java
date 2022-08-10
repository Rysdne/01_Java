package di.annotation4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		// ApplicationContext factory = new ClassPathXmlApplicationContext("di/annotation2/setting.xml");
		// Student student=(Student)factory.getBean("s");
		// System.out.println(student.toString());
		// xml 파일이 없어서 위 객체는 사용 불가
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SettingConfig.class);
		Student student=(Student)ctx.getBean("student");
		System.out.println(student.toString());
		
	}

}
