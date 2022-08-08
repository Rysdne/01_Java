package test220712;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int num = 0;
		String op = "";
		int a = 0;
		int b = 0;
		Cal cal;
		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			num = sc.nextInt();
			if (num < 1 || num > 5) {
				System.out.println("목록에 맞는 숫자를 입력하세요");
			} else {
				switch (num) {
				case 1:
					op = "+";
					break;
				case 2:
					op = "-";
					break;
				case 3:
					op = "*";
					break;
				case 4:
					op = "/";
					break;
				case 5:
					System.out.println("프로그램을 종료합니다");
					System.exit(0);
					break;
				}
				System.out.println("계산할 두 수를 입력해주세요");
				a = sc.nextInt();
				b = sc.nextInt();
				cal = new Cal(a, b, op);
				if (op.equals("/")) {
					System.out.println("결과 : " + cal.getResult());
					System.out.println("");
				} else {
					System.out.println("결과 : " + (int) cal.getResult());
					System.out.println("");
				}
			}
		}
	}

	public static void menu() {
		System.out.println("==========");
		System.out.println("| 1)  +   |");
		System.out.println("| 2)  -   |");
		System.out.println("| 3)  *   |");
		System.out.println("| 4)  /   |");
		System.out.println("| 5) 종료  |");
		System.out.println("===========");
	}

}
