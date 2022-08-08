package basic220607;

//===================================================

// Value Object : 한 데 뭉쳐서 저장한 뒤 한 번에 보낼 수 있는 저장공간

// 1. 클래스 생성
public class MemberVO {
	// ...............................................

	// 2. 폐쇄된 변수(속성) 선언
	private String id;
	private String pw;
	// ...............................................

	// 3. 생성자 함수 생성
	public MemberVO() {
	}

	// 필드가 있는 생성자 함수 생성
	// 우클릭 > Source > Generate Constructor using Fields...
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

//	// 1) 묶어놓기
//	// 불러오기 쉽게 자기 자신을 미리 묶어놔도 됨
//	public MemberVO(MemberVO mb) {
//
//		String id = this.getId();
//		String pw = this.getPw();
//
//	}
	// ...............................................

	// 4. 생성한 속성에 대한 get, set 함수 생성
	// 직접 접근할 수 없기 때문에 Get, Set 함수가 필요
	// 우클릭 > Source > Generate Getter and Setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	// ...............................................

	// 5. toString 오버라이딩
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + "]";
	}
	// ...............................................

}
