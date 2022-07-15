package basic220518;

class Sungjuk{
int kor;
int eng;
int math;
public Sungjuk(int kor, int eng, int math) {
	this.kor=kor;
	this.eng=eng;
	this.math=math;
}
public void print() {
	System.out.println(kor+" "+eng+" "+math);
}
}

public class TwoClass {
public static void main(String[] args) {
	Sungjuk sj=new Sungjuk(100, 100, 100);
	sj.print();
}
}
