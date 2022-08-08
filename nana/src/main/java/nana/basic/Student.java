package nana.basic;

public class Student {

	// 객체
	Sungjuk sj;

	// 일반 변수
	String id;
	String name;

	// 1번째 방법
	// 기본생성자
	public Student() {
		sj = new Sungjuk();
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

}
