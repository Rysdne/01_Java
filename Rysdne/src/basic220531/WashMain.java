package basic220531;

public class WashMain {

	public static void main(String[] args) {
		Wash w = new Wash(25);
		WashLG wlg = new WashLG(50);
		WashSam wsm = new WashSam(75);

		w.perform();
		System.out.println("======================");
		System.out.println("");

		wlg.performLG();
		System.out.println("======================");
		System.out.println("");

		wsm.performSam();
		System.out.println("======================");
		System.out.println("");

	}

}
