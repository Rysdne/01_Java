package basic220527;

public class MemoMain {

	public static void main(String[] args) {

// =======================================================

		// 문제.Memo클래스 배열변수 5개를 만들고 필드생성자를 이용해 5개의 객체를 생성하고 출력하세요.

		// 1) 배열 선언
		// 클래스를 배열로 new 객체를 선언하는 것은 객체 생성을 하는 것이 아님
		// 배열 공간을 확보하기 위한 작업일 뿐
		String arr[] = new String[7];
		// ...............................................

		// 2) 배열에 Memo 클래스의 toString을 불러와 저장 후 출력
		for (int i = 0; i < 5; i++) {
			Memo m = new Memo(i + 1, "rysdne_" + (i + 1));
			// Memo 클래스
			arr[i] = m.toString();
			System.out.println(arr[i]);
		}

// =======================================================

		// # 객체인지 아닌지 판별하는 방법
		// 인덱스 값을 0과 6을 입력해서 판별
		for (int index = 0; index * 6 < arr.length; index++) {
			if (arr[index * 6] != null) {
				System.out.println((index * 6) + " 공간에 메모 객체가 생성되어 있습니다");
			} else {
				System.out.println((index * 6) + " 공간에 메모 객체가 생성되지 않았습니다");
			}
		}

// =======================================================
	}

}
