package basic220531;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//=======================================================

// KeyListener : 키 입력을 기다리는 인터페이스(?)
// 윈도우에서만 사용할 수 있는 인터페이스
public class Taja implements KeyListener {
	// ...............................................

	// 1. Key가 입력되었을 경우(?)
	// e : 전달되는 객체
	@Override
	public void keyTyped(KeyEvent e) {

	}
	// ...............................................

	@Override
	// 2. key가 눌렸을 경우
	// e.getKeyChar() : e에 저장된 키값을 반환하는 함수
	public void keyPressed(KeyEvent e) {
		System.out.print(e.getKeyChar());
	}
	// ...............................................

	// 3. key가 떼어졌을 경우
	@Override
	public void keyReleased(KeyEvent e) {

	}
	// ...............................................
}

//=======================================================
