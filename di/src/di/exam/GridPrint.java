package di.exam;

import org.springframework.stereotype.Component;

//@Component("gridPrint")
@Component
public class GridPrint implements Print {

	@Override
	public void print(String name, int kor, int eng, int math) {
		System.out.println("-----------------------");
		System.out.println("name | kor | eng | math");
		System.out.println("-----------------------");
		System.out.println("|" + name + " | " + kor + " | " + eng + " | " +  math);
		System.out.println("-----------------------");
	}

}
