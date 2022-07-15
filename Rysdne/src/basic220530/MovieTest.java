package basic220530;

// Movie 클래스 선언
class Movie {
	// 필드에 part 변수 초기화
	String part = "영화";
}

// Movie 클래스 상속받음1
class Korea extends Movie {
	String m1 = "가문의 위기";

}

//Movie 클래스 상속받음2
class Foreign extends Movie {
	String m2 = "스파이더맨";

}

public class MovieTest {

	public static void main(String[] args) {
		// Korea 객체 선언(불러오기)
		Korea k = new Korea();
		// 필드에 멤버변수를 만들어놨기 때문에 모든 클래스에서 part 사용 가능
		System.out.println("장르 : " + k.part);
		System.out.println("제목 : " + k.m1);
		
		Foreign f = new Foreign();
		System.out.println("장르 : " + f.part);
		System.out.println("제목 : " + f.m2);

	}

}
