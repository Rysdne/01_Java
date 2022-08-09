package di.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// 클래스 파일 업로드
		ApplicationContext factory = new ClassPathXmlApplicationContext("di/test/setting.xml");

		// 반드시 Student 형으로 변경해줘야 Bean 사용이 가능함
		Student student = (Student) factory.getBean("student1");

		System.out.println(student.toString());

		student = (Student) factory.getBean("student2");

		System.out.println(student.toString());

		student = (Student) factory.getBean("student3");

		System.out.println(student.toString());

		student = (Student) factory.getBean("student4");

		System.out.println(student.toString());

		student = (Student) factory.getBean("student5");

		System.out.println(student.toString());

		// 기존 방법 : List<String> list=new ArrayList<String>();
		// 실제 형태 : List<String> list=new java.util.ArrayList<String>();
		// 삽입 01 : list.add("~~~");
		// 삽입 02 : Arrays.asList("~~~","~~~");

		ArrayList<String> list = new ArrayList<String>(Arrays.asList("banana", "orange", "apple"));
		System.out.println("ArrayList : " + list);

		List<String> list1 = new ArrayList<String>(Arrays.asList("banana", "orange", "apple"));
		System.out.println("list1 : " + list1);

		// List<String> list2 = new ArrayList<String>(Arrays.asList("aaa", "bbb",
		// "ccc"));
		// System.out.println("list2 : " + list2);

		List<String> list3 = (List) factory.getBean("list");
		System.out.println("list3 : " + list3.toString());
		
		List<String> list4 = (List) factory.getBean("ulist");
		System.out.println("ulist : " + list4.toString());
		

	}

}
