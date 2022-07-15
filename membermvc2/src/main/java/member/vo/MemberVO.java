package member.vo;

//===================================================

// Value Object : 한 데 뭉쳐서 저장한 뒤 한 번에 보낼 수 있는 저장공간

// 1. 클래스 생성
public class MemberVO {
	// ...............................................

	// 2. 폐쇄된 변수(속성) 선언
	private int idx;
	private String id;
	private String password;
	// ...............................................

	// 3. 생성자 함수 생성
	public MemberVO() {
	}

	// 필드가 있는 생성자 함수 생성
	// 우클릭 > Source > Generate Constructor using Fields...
	public MemberVO(int idx, String id, String password) {
		this.idx = idx;
		this.id = id;
		this.password = password;
	}

//	// 1) 묶어놓기
//	// 불러오기 쉽게 자기 자신을 미리 묶어놔도 됨
//	public MemberVO(MemberVO mb) {
//
//		String id = this.getId();
//		String password = this.getpassword();
//
//	}
	// ...............................................

	// 4. 생성한 속성에 대한 get, set 함수 생성
	// 직접 접근할 수 없기 때문에 Get, Set 함수가 필요
	// 우클릭 > Source > Generate Getter and Setter

	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	// ...............................................

	// 5. toString 오버라이딩
	@Override
	public String toString() {
		return "MemberVO [idx=" + idx + ", id=" + id + ", password=" + password + "]";
	}
	// ...............................................

}
