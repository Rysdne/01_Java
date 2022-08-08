package basic220530;

//=======================================================

// 1. 조상 클래스 생성
class Car {

	// 생성자 함수 초기화
	public Car() {
		System.out.println("car 생성자 호출");
	}

	// 함수 생성
	public void gear() {
		System.out.println("수동 기어 사용");
	}
}
//...............................................

// 2. Car를 상속받는 ChildCar1 클래스 생성
class ChildCar1 extends Car {

	// 생성자 함수 초기화
	public ChildCar1() {
		System.out.println("ChildCar1 생성자 호출");
	}

	public void autoGear() {
		System.out.println("자동 기어 사용");
	}
}
//...............................................

// 3. ChildCar1을 상속받는 ChildCar2 클래스 생성
class ChildCar2 extends ChildCar1 {

	// 생성자 함수 초기화
	public ChildCar2() {
		System.out.println("ChildCar2 생성자 호출");
	}

	public void hybrid() {
		System.out.println("하이브리드 기어 사용");
	}

	// 오버라이드 함수 : 기존에 선언한 함수를 새로 변경함
	@Override
	public void autoGear() {
		
		// super : 부모로부터 상속받은 autoGear 메소드를 의미
		// super.autoGear();
		// 오버라이드 하더라도 기존에 상속받은 내용이 완전히 지워지는 것은 아님
		
		System.out.println("새로운 자동 기어 사용");
	}
}
//...............................................

//=======================================================

public class CarTest {

	public static void main(String[] args) {

// =======================================================

//		// 3.객체 호출
//		// 1) Car 객체 생성
//		new Car().gear();
//		// Car car = new Car(); car.gear(); 과 같은 명령
//		// 어디에도 상속되지 않은 Car를.. no
//		// 이미 ChildCar2 클래스에 모든 클래스가 상속되어있어서 쓸 데 없는 명령임
//		// ...............................................

//		// 2) ChildCar1 객체 생성
//		ChildCar1 cc1 = new ChildCar1();
//		// 이미 ChildCar2 클래스에 모든 클래스가 상속되어있어서 쓸 데 없는 명령임
//
//		// 멤버변수에 정의된 내용을 불러올 수 있음
//		cc1.gear();
//		cc1.autoGear();
//		// ...............................................

		// 3) 자식 클래스 객체 생성 시 부모 클래스의 객체가 먼저 생성됨
		ChildCar2 cc2 = new ChildCar2();

		cc2.gear();
		cc2.autoGear();
		cc2.hybrid();

// =======================================================		

	}

}
