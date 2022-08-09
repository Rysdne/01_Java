package di.annotation2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sungjuk {

	@Value("100")
	int kor;
	@Value("100")
	int eng;
	@Value("100")
	int math;

	public Sungjuk() {
	}

	public Sungjuk(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Sungjuk [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

}
