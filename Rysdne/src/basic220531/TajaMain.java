package basic220531;

import java.awt.Frame;

public class TajaMain {

	public static void main(String[] args) {

		// 이런 식으로 사용
		Taja taja = new Taja();

		// 윈도우 창에 입력하는 내용을 Char 형식으로 입력
		Frame f = new Frame();
		f.setBounds(200,100,300,300);
		f.setVisible(true);
		f.addKeyListener(taja);

	}

}
