package main.basic2;

public class Student {

	// 객체
	Sungjuk sj;

	// 일반 변수
	String id;
	String name;

	// 1번째 방법
	// 기본생성자
	public Student() {
	}

	public Student(Sungjuk sj, String id, String name) {
		super();
		this.sj = sj;
		this.id = id;
		this.name = name;
	}

	// 2번째 방법
	// 변수 주입
	public Student(Sungjuk sj) {
		this.sj = sj;
	}

	// 3번째 방법
	// set
	public void setSungjuk(Sungjuk sj) {
		this.sj = sj;
	}

	public Sungjuk getSj() {
		return sj;
	}

	public void setSj(Sungjuk sj) {
		this.sj = sj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [sj=" + sj + ", id=" + id + ", name=" + name + "]";
	}

}
