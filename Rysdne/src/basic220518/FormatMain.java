package basic220518;

import java.text.DecimalFormat;

public class FormatMain {

	public static void main(String[] args) {

		int price = 1000000;
		// tntwk 1000000->1,000,000 표현으로 변경
		DecimalFormat f = new DecimalFormat("###,##0");
		String p = f.format(price); // format 함수는 데이터를 스트링으로 받아옴(?)
		System.out.println(p);
	}

}
