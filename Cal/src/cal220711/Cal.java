package cal220711;

public class Cal {
	
//	// =======================================================
//	// 1. 기본적인 함수 구성
////	// 1) 개수 고정 
////	String[] history = new String[10];
//
//	// 2) 개수 입력
//	String[] history;
//	int position = 0;
//
//	public Cal() {
//		history = new String[1];
//	}
//
//	public Cal(int size) {
//		history = new String[size];
//	}
//
//	public int add(int a, int b) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(a).append("+").append(b).append("=").append(a + b);
//		history[position++] = sb.toString();
//		return a + b;
//	}
//
//	public int sub(int a, int b) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(a).append("-").append(b).append("=").append(a - b);
//		history[position++] = sb.toString();
//		return a - b;
//	}
//
//	public int mux(int a, int b) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(a).append("*").append(b).append("=").append(a * b);
//		history[position++] = sb.toString();
//		return a * b;
//	}
//
//	public float div(int a, int b) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(a).append("/").append(b).append("=").append(a / b);
//		history[position++] = sb.toString();
//
//		return (float) a / b;
//	}
//
//	public void historyprn() {
//
////		// 기본적으로 출력하는 형태
////		// 이슈 : 입력하지 않은 라인도 다 나옴
////		for(String a:history) {
////			System.out.println(a);
////		}
//
//		// 입력한 수만큼 출력
//		for (int i = 0; i < position; i++) {
//			System.out.println(history[i]);
//		}
//
//	}
//	
//	// ...............................................

	// 2. 반복구문 최적화
	String[] history;
	int position = 0;

	public Cal() {
		history = new String[1];
	}

	public Cal(int size) {
		history = new String[size];
	}

	
	
	
	public int add(int a, int b) {
		writeHistory(a,b,'+');
		return a + b;
	}

	public int sub(int a, int b) {
		writeHistory(a,b,'-');
		return a - b;
	}

	public int mux(int a, int b) {
		writeHistory(a,b,'*');
		return a * b;
	}

	public float div(int a, int b) {
		writeHistory(a,b,'/');
		return (float) a / b;
	}

	public void historyprn() {

		for (int i = 0; i < position; i++) {
			System.out.println(history[i]);
		}

	}

	public void writeHistory(int a, int b, char op) {
		StringBuilder sb = new StringBuilder();
		float rs=0;
		switch(op) {
		case '+' : rs=a+b; break;
		case '-' : rs=a-b; break;
		case '*' : rs=a*b; break;
		case '/' : rs=(float)a/b; break;
		}
		sb.append(a).append(op).append(b).append("=").append(rs);
		history[position++] = sb.toString();
	}
	
	// =======================================================
	
}
