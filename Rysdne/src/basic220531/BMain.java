package basic220531;

public class BMain {

	public static void main(String[] args) {

		BRysdne rysdne = new BRysdne();

		System.out.println("Rysdne은 "+rysdne.damage(0, 5)+" 데미지를 받았다");
		System.out.println("Rysdne은 "+rysdne.status("경계")+" 상태를 취했다");
		
	}

}
