package basic220531;

// 추상 클래스 내부의 추상 메소드를 사용하기 위해서는 반드시 상속을 통해 구현해야 함
class AA extends AbstractA {

	@Override
	public void print() {
		System.out.println("^^^^^");
	}
}

// abstract : 추상 클래스 선언
// 최소 1개의 추상 메소드를 가져야 함
// 이외의 다른 메소드를 가져도 됨
public abstract class AbstractA {

	// 일반 메소드
	public void display() {
		System.out.println("*****");
	}

	// abstract : 추상 메소드 선언
	public abstract void print();

}
