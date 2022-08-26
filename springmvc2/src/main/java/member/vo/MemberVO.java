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

	// 로그인에는 id와 password만 사용하기 때문에 생성자를 새로 만들어줘야 함
	public MemberVO(String id, String password) {
		this.id = id;
		this.password = password;

	}

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
