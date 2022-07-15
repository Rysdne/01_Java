package basic220530;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//=======================================================

// 1. 클래스 및 인터페이스 상속
// Frame을 조상으로 MyWindow에 불러옴
// extends : 다른 클래스에 있는 내용을 상속받겠음
//  ㄴ> 상속은 한 번에 하나의 클래스에서만 가능, C++의 경우는 2개 이상 상속 가능
// implements : 이 내용을 구현하겠음, 앞으로 엄청 많이 나올걸?
public class MyWindow extends Frame implements WindowListener {

// WindowListener는 클래스가 아닌 인터페이스, 
// class <이름> { 함수 ( ) = { };} : 이미 정의되어있고 구현되어있음		-> 바로 사용 가능
// interface <이름> { 함수( );} : 정의는 되어있으나 구현되어있지 않음		-> 속성값을 설정해줘야 함 
//  ㄴ> Add unemplemented methods : 필요한 메소드(함수)를 불러와야 사용 가능
//	// ...............................................

//	// 2. 일반적인 상속 방법 (Frame 클래스 사용)
//	public static void main(String[] args) {
//
//		// 윈도우 객체 초기화
//		MyWindow win = new MyWindow();
//		// 윈도우 창 영역 설정
//		win.setBounds(100, 100, 300, 300);
//		// 윈도우 창 열기(보이게 하기)
//		win.setVisible(true);
//
//		// 윈도우 창 끄려면 정지버튼
//	}
//	// ...............................................

	// 3. 더 쉬운 상속 방법 (Frame 클래스 사용)
	// 생성자 함수는 자신이 선언될 때 사용됨
	public MyWindow() {

		// set 함수 : 속성을 변환시키는 함수
		// 1) 윈도우 창 영역 설정 (시작 x좌표, 시작 y좌표, x좌표 길이, y좌표 길이)
		this.setBounds(200, 200, 500, 500);
		// 2) 윈도우 창 열기(보이게 하기)
		this.setVisible(true);
		// 3) 이 함수 내에서 인터페이스 사용 선언(?)
		addWindowListener(this);
	}
//	// ...............................................

	// 윈도우 인터페이스 설정 함수 (WindowListener 인터페이스 사용)
	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// x버튼 누르면 삭제
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}

//=======================================================
