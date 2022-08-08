package basic220516;

public class Main {
	public static void main(String[] arg) {
		Sungjuk sungjuk1 = new Sungjuk();//생성자 함수 호출
		Sungjuk sungjuk2 = new Sungjuk();//생성자 함수 호출
		Sungjuk sungjuk3 = new Sungjuk();//생성자 함수 호출

		sungjuk1.kor = 40;
		sungjuk1.eng = 80;
		sungjuk1.math = 100;
		//합계, 평균
	
		sungjuk1.updateSum();
		sungjuk1.updateAverage();
		sungjuk1.print();

		sungjuk2.input(80, 80, 80);
		sungjuk2.print();
		sungjuk3.input(91, 83, 100);
		sungjuk3.print();

	}
}