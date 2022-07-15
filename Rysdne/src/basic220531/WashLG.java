package basic220531;

public class WashLG extends Wash {

	public WashLG() {
	}

	public WashLG(int spd) {
		this.spd = spd;
	}

	@Override
	public void changeButton(int spd) {
		if (spd < 10 || spd > 100) {
			System.out.println("======================");
			System.out.println(" LG : 속도를 변경할 수 없음");
			System.out.println("======================");
		} else {
			System.out.println("======================");
			System.out.println(" LG : 속도를 " + spd + "(으)로 변경");
			System.out.println("======================");
		}
	}

	public void dry() {
		System.out.println("| 4. 건조 시작\t|");
	}

	public void performLG() {
		changeButton(spd);
		startButton();
		stopButton();
		pauseButton();
		dry();
	}
}
