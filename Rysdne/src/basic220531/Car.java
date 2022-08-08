package basic220531;

public class Car implements CarFunc {

	String name;
	int cc;
	int year;

	public Car() {
	}

	public Car(String name, int cc, int year) {
		this.name = name;
		this.cc = cc;
		this.year = year;
	}

	@Override
	public void movehandle() {
		System.out.println("|  1. 핸들 조작\t|");
	}

	@Override
	public void controllerAcc() {
		System.out.println("|  2. 액셀 조작\t|");
	}

	@Override
	public void controllerBreak() {
		System.out.println("|  3. 브레이크 조작\t|");
	}

	@Override
	public void controllerWindow() {
		System.out.println("|  4. 창문 조작\t|");
	}

	public void CarStatus() {
		System.out.println("===# 차량 정보 #====");
		System.out.println("|  이름 : " + name + "\t|");
		System.out.println("| 배기량 : " + cc + "cc\t|");
		System.out.println("|  모델 : " + year + "연식\t|");
		System.out.println("===# 차량 기능 #====");
		movehandle();
		controllerAcc();
		controllerBreak();
		controllerWindow();
		System.out.println("=================");
	}

}
