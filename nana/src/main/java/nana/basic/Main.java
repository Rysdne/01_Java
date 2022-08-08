package nana.basic;

public class Main {

	public static void main(String[] args) {

//		// 클래스 내에 객체를 주입
//		// 1) 기본 생성자에 전달
//		Student student = new Student();
		
//		// 2) 외부에 생성 후 생성자 함수에 전달함
//		Sungjuk sj = new Sungjuk();
//		Student student = new Student(sj);
		
		// 3) 객체 생성 후 set 함수 사용
		Sungjuk sj = new Sungjuk();
		Student student = new Student();
		student.setSungjuk(sj);


		// Q1) 최종적으로 사용하려는 객체는?
		// A1) Student 객체
		
		// Q2) Student 객체를 사용하기 위해 필요한 객체는?
		// A2) Sungjuk 객체 필요
		
	}

}
