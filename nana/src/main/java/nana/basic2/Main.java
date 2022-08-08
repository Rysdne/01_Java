package nana.basic2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// 1. add on 설치 (beans xml 파일 지원)
		// 2. beans xml 생성 (Spring Bean Configuration File)
		// 3. setting.xml 파일 내에 Sungjuk, Student bean 등록
		// 4. pom.xml에 Spring Context 라이브러리 추가
		// 5. main 함수에서 ApplicationContext 생성
		// 6. getBean 함수를 이용해 생성된 객체를 주입
		
//		Sungjuk sj = new Sungjuk();
//		Student student = new Student();
//		student.setSungjuk(sj);

		// 현재 src가 기본 디렉터리
		ApplicationContext factory = new ClassPathXmlApplicationContext("main/nana/basic2/setting.xml");
		
		// 팩토리로부터 student를 들고와 bean을 가져옴 
		Student student=(Student)factory.getBean("student");
		System.out.println(student.toString());
		
	}

}
