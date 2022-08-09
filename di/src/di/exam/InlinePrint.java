package di.exam;

import org.springframework.stereotype.Component;

//@Component("inlinePrint")
@Component
public class InlinePrint implements Print {

	@Override
	public void print(String name, int kor, int eng, int math) {
		System.out.println("name : " + name);
		System.out.println("kor : " + kor);
		System.out.println("eng : " + eng);
		System.out.println("math : " + math);
		
	}

}
