package di.annotation4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//컴포넌트 스캔을 하지 않게 되어 필요가 없음
//@Component
public class Sungjuk {

	// 어노테이션이 setting에서의 값 입력보다 이후에 동작하여 어떤 값을 넣어도 @Value값이 입력됨
	// 이걸 제거해준 뒤 테스트
	//@Value("100")
	int kor;
	//@Value("100")
	int eng;
	//@Value("100")
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
