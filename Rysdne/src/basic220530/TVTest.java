package basic220530;

//=======================================================

// 1. TV 클래스
class TV {
	// size 속성 선언
	int size;

	// 기본 생성자 함수 선언
	// 본래 별도로 만들지 않아도 상관 없으나, 익숙해지라고 써 놓은 것
	// 자식 클래스에서 사용하기 위해서는 '인자 없는 부모 클래스'를 선언해놓아야 사용 가능
	public TV() {
	}


	// 인자가 있는 생성자 함수 선언
	public TV(int size) {
		this.size = size;
		System.out.println("TV 사이즈 : " + size);
	}

	// size 값을 받아오는 함수 선언
	// return 함수이기 때문에 int형임을 선언해줌
	public int getSize() {
		return size;
	}
}
//...............................................

// 2. TV 클래스를 상속받은 ColorTV 클래스
class ColorTV extends TV {

	// color 속성 선언
	int color;

	// 접근 제한자를 생략하면 default로 적용
	// default : 동일 패키지 안에서만 허용
	// 인자가 없는 생성자함수라도 상속이 필요한 순간 사용할 수 없게 됨
	public ColorTV() {
	}

	public ColorTV(int size, int color) {
		// 상속을 받았기 때문에 속성을 물려받음
		this.color = color;
		this.size = size;
		// size는 위에서 상속받을 수 있기 때문에 this 대신 super라고 해도 됨
		// 그러나 엄연히 말해서는 다름
		// 1) this는 완벽하게 상속받은 결과물을 사용하는 것
		// 2) super를 사용하면 특정 상속 환경에서의 값을 사용할 수 있음

		
	}

	// color 값을 받아오는 함수 선언
	public int getColor() {
		return color;
	}

	// 부여받은 값을 출력하는 함수 print() 선언
	public void print() {
		System.out.println("사이즈 : " + getSize() + "인치");
		System.out.println("색상 : " + getColor() + "색");
	}

}
//...............................................

// 3. ipTV 클래스
class IpTV extends ColorTV {

	// ip 속성 선언
	String ip;

	// 더이상 상속할 내용이 없는 생성자 함수는 private로 사용해도 됨
	private IpTV() {
	}

	public IpTV(int size, int color, String ip) {
		this.size = size;
		this.color = color;
		this.ip = ip;
	}

	// ip 값을 받아오는 함수 선언
	// return 함수이기 때문에 String형임을 선언해줌
	public String getIP() {
		return ip;
	}

	// 상속받은 ColorTV 클래스에 있는 함수를 Override 하여 출력 내용 수정
	@Override
	public void print() {
		System.out.println("사이즈 : " + getSize() + "인치");
		System.out.println("색상 : " + getColor() + "색");
		System.out.println("IP : " + getIP());
	}
}
//=======================================================

//=======================================================

public class TVTest {
	public static void main(String[] args) {

		// ipTV 클래스에 인자 입력 후 프린트
		// 객체 생성 시 괄호를 붙이지 않아도 되던데 왜 붙이는지는 의문 
		// (new IpTV(32, 256, "192.168.0.10")).print();
		new IpTV(32, 256, "192.168.0.10").print();

	}
}

//=======================================================