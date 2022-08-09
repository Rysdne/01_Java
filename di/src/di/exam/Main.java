package di.exam;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SettingConfig.class);
		Student student=(Student)ctx.getBean("student");
		student.getPrint().print("홍길동", 100, 98, 99);
		
	}

}
