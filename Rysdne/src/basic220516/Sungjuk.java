package basic220516;
public class Sungjuk{
	//Sungjuk(){ }
	//클래스는 속성과 함수로 구성

	//맴버변수 or 속성
	int kor;
	int eng;
	int math;
	int total;
	float avg;

	//생성자 함수 정의(재정의-오브라이더)
	Sungjuk(){ 
	System.out.println("객체가 생성되었습니다.");
	kor=0;
	eng=0;
	math=0;
	}

	//맴버함수
	void print(){
	//System.out.printf("%d %d %d\n", kor, eng, math);
	System.out.println("kor:"+ kor+"eng:"+eng+"math:"+ math+"total:"+total+ " avg:" + avg);
	}

	//입력함수
	void input(int kor, int eng, int math){
	this.kor=kor;
	this.eng=eng;
	this.math=math;
	total=kor+eng+math;
	avg=(float)total/3;
	}

	//합계함수, 평균함수
	void updateSum(){
	total=kor+eng+math;
	}

	void updateAverage(){
	avg=(float)total/3;
	}

	}