package basic220519;

/*
 * 자동차를 만드려고 함
 * 자동차는 차량명, 배기량, 판매가격, 탑승인원, 최고속도, 판매자, 전화번호 정보가 들어있음
 * get set 형태로 만들기
 * carContents에는 모든 차량 정보를 출력
 * buyInfo에는 판매자 정보를 출력
 * carChange는 2개의 입력값을 받아 변경하는 함수
 * 
 */

public class CarInfo {

	// 차량명, 배기량, 판매가격, 탑승인원, 최고속도, 구매자, 전화번호
	String cname;
	int cc;
	double price;
	int person;
	int speed;
	String name;
	String tel;

	// 생성자 함수를 생성하여 메모리 공간 확보, 에 위 내용 추가
	// CarInfo( ) { }와 다름, 안에 내용이 입력되지 않음
	// ( ) 내부에는 값이 들어감
	// 다른 페이지에서 CarInfo()를 불러오기 위해서는 기본 생성자인 CarInfo(){}를 만들어줘야 함 
	CarInfo(String cname, int cc, double price, int person, int speed) {
		// 위처럼 괄호 안에 값을 넣어도 바로 저장되는 것이 아님, 해당 공간만 마련할 뿐임

		// 차량명, cc, 가격, 탑승인원, 최고속도 내용 입력
		this.cname = cname;
		this.cc = cc;
		this.price = price;
		this.person = person;
		this.speed = speed;
	}

	// 기능1) 차 정보 표시
	void carContents() {
		System.out.println("차량명 : " + cname);
		System.out.println("배기량 : " + cc + "cc");
		System.out.println("판매가 : " + price + "만원");
		System.out.println("탑승인원 : " + person + "명");
		System.out.println("최고속도 : " + speed + "km/h");
	}

	// 기능2) 구매자 정보 표시
	void buyInfo() {
		System.out.println("구매자 : " + name);
		System.out.println("전화번호 : " + tel);
	}

	// 기능3) 입력값 수정
	void buyChange(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
