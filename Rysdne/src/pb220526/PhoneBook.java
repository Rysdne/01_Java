package pb220526;

public class PhoneBook {

	// 이름, 전화번호, 메모(멤버변수)
	String name;
	String tel;
	String memo;

	// 생성자 함수 생성
	PhoneBook() {
	}

	// 전달값(인자)이 있는 생성자 함수 생성
	PhoneBook(String name, String tel, String memo) {
		this.name = name;
		this.tel = tel;
		this.memo = memo;
	}


	void view() {
		System.out.println("===================");
		System.out.println("이름 : "+name);
		System.out.println("번호 : "+tel);
		System.out.println("메모 : "+memo);
	}

	
	public void update(String name, String tel, String memo) {
		this.name = name;
		this.tel = tel;
		this.memo = memo;
	}

	public void delete(String name, String tel, String memo) {
		this.name = name;
		this.tel = tel;
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "PhoneBook [name=" + name + ", tel=" + tel + ", memo=" + memo + "]";
	}

}
