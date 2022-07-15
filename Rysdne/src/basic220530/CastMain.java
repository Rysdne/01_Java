package basic220530;

//=======================================================

class My {
	String name;

	public My() {
	}

	public My(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println("이름 : " + name);
	}
}
//...............................................

////1. 일반적으로 사용하는 형태
//public class CastMain {
//
//	public static void main(String[] args) {
//
//		My m1 = new My("동균");
//		My m2 = new My("굔욷");
//		m1.print();
//		m2.print();
//
//		m2 = m1;
//		m1.print();
//		m2.print();
//	}
//}
//// ...............................................

// 2. 부모 = 자식 형변환
class Myup extends My {
	int age;

	public Myup() {
	}

	public Myup(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void printup() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}

}

public class CastMain {
	public static void main(String[] args) {
		My my = new My("동균");
		Myup myup = new Myup("굔욷", 33);
		// ...............................................

//		// 1) 부모 = 자식 (o)
//		my = myup;
//		my.print();
//		// 부모밖에 안나옴
//		// ㄴ> 자식 내부에 부모의 고유한 공간이 존재하기 때문에 사용 가능함
//		// ...............................................

//		// 2) 자식 = 부모 (x)
//		// myup=my;
//		// 들어가질 않음
//		//  ㄴ> 자식이 이미 부모로부터 상속하였기 때문에 형변환 불가
//		//...............................................

		// 3) 형변환된 객체는 자식의 함수를 사용할 수 없음
		// 부모 = 자식의 형태로 형변환
		My my1 = new Myup("rysdne", 33);

		// 3-1) 부모 클래스에 정의된 함수는 사용할 수 있음
		my1.print(); // (o)

		// 3-2) 자식 클래스에 정의된 함수는 사용할 수 없음
		// my1.printup(); // (x)
		// ...............................................

		// 3-3) 형변환이 가능한 지 확인하는 연산자
		// instanceof : 들어갈 수 있냐 없냐를 확인해주는 도구 [true|false]
		System.out.println(my1 instanceof Myup);
		// ...............................................

//		// 4) 강제형변환(?)
//		// 부모 클래스의 타입을 자식 클래스로 강제 형변환
//		// 자식 클래스의 메소드를 호출할 수 있음
//		
//		// xxxxxx 공사중 xxxxxx
//		// 문법에는 맞는데 뭔가 안됨
//		// myup=(Myup)my;
//		// myup.print();
//		// xxxxxxxxxxxxxxxxxx
//		// ...............................................
	}
}

//=======================================================