package basic220531;

abstract class SPanel {
	public void on() {
		System.out.println("panel을 켭니다");
	}

	public void off() {
		System.out.println("panel을 끕니다");
	}

	// 추상 메서드라 abstract
	// 로고는 너네들이 만들어
	public abstract void logo();
}

class Company1 extends SPanel {

	@Override
	public void logo() {
		System.out.println("Company 1 Logo");
	}

}

class Company2 extends SPanel {

	@Override
	public void logo() {
		System.out.println("Company 2 Logo");
	}

}

public class PanelMain {

	public static void main(String[] args) {

		Company1 c1=new Company1();
		Company2 c2=new Company2();
		
		c1.on();
		c1.off();
		c1.logo();
		
		c2.on();
		c2.off();
		c2.logo();
		
		
	}

}
