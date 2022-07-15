package basic220531;

public class Wash implements WashInter {
	int spd;

	public Wash() {
	}

	public Wash(int spd) {
		this.spd = spd;
	}

	@Override
	public void startButton() {
		System.out.println("| 1. 세탁 시작\t|");
	}

	@Override
	public void stopButton() {
		System.out.println("| 2. 세탁 중지\t|");
	}

	@Override
	public void pauseButton() {
		System.out.println("| 3. 일시정지\t|");
	}

	@Override
	public void changeButton(int spd) {
		if (spd < 10 || spd > 100) {
			System.out.println("======================");
			System.out.println("세탁기 : 속도를 변경할 수 없음");
			System.out.println("======================");
		} else {
			System.out.println("======================");
			System.out.println("세탁기 : 속도를 " + spd + "(으)로 변경");
			System.out.println("======================");
		}
	}

	public void perform() {
		changeButton(spd);
		startButton();
		stopButton();
		pauseButton();
	}

}
