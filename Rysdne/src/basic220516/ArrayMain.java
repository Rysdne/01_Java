package basic220516;

public class ArrayMain {

	public static void main(String[] args) {
		int[] pay = { 1000, 2000, 3000, 4000 };
		int pay1[] = { 100, 200, 300, 400 };
		/*
		 * for (int i : pay) { System.out.println(i); }
		 */
		int pay2[] = new int[5];
		System.out.println(pay1.hashCode());
		System.out.println(pay2.hashCode());

		/*
		 * pay2=pay1; pay2는 pay1의 저장공간을 참조한다
		 */

		pay2[0] = 1;
		pay2[1] = 2;
		pay2[2] = 3;
		pay2[3] = 4;
		pay2[4] = 500;

		System.out.println(pay[1]);
		
		for (int i : pay2) {
			System.out.println(i);
		}

	}
}
