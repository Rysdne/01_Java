package basic220519;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookMenu {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Phonebook[] pb = new Phonebook[100];
		int index = 0; // 저장할 위치 초기값
		int select = 0; // 메뉴번호를 선택하기 위한 초기값
		String search;
		String name;
		String tel;
		String memo;

		while (true) {

			menu();
			select = scan.nextInt();

			// 화면 클리어 함수 생성, 근데 줄을 줄을 밀어내는걸로 하는거라 야매임
			sclr();

			switch (select) {

			case 1:
				System.out.println("이름을 입력하세요");
				System.out.println("[취소 : exit]");
				name = scan.next();
				System.out.println("");
				if (name.equals("exit")) {
					break;
				}
				System.out.println("번호를 입력하세요");
				System.out.println("[취소 : exit]");
				tel = scan.next();
				System.out.println("");
				if (tel.equals("exit")) {
					break;
				}
				System.out.println("메모를 입력하세요");
				System.out.println("[취소 : exit]");
				memo = scan.next();
				System.out.println("");
				if (memo.equals("exit")) {
					break;
				}

				// 저장 위치를 1씩 증가시킴
				pb[index++] = new Phonebook(name, tel, memo);
				System.out.println("번호가 추가되었습니다");
				System.in.read();
				sclr();
				break;

			case 2:
				if (index < 1) {
					System.out.println("조회할 데이터가 없습니다");
					System.in.read();
					sclr();
					break;
				} else {
					for (int i = 0; i < index; i++) {
						if (!pb[i].name.equals("")) {
							pb[i].view();
							System.in.read();
							sclr();
							break;
						}

					}
				}
				break;
			case 3:
				System.out.println("검색할 이름을 입력하세요");
				search = scan.next();
				// 저장공간을 의미하는 i가 index(저장된 최대치+1)보다 작은 수가 될 때까지 반복
				for (int i = 0; i < index; i++) {
					// if) pb[i]에 저장된 값이 입력한 name 값과 동일한가
					if (search.equals(pb[i].name)) {
						pb[i].view();
						System.in.read();
						sclr();
						break;
					}
					// if) pb[i]에 저장된 값이 입력한 name 값과 동일하지 않고(break), i가 index(저장된 최대치+1)-1일 경우
					// -> 모든 공간을 다 봤는데도 동일한 name 값이 없는 경우
					if (i == index - 1) {
						System.out.println("해당 이름을 가진 데이터가 없습니다");
						System.in.read();
						sclr();
						break;
					}
				}
				break;
			case 4:
				// 수정은 먼저 데이터가 있는지를 확인해야 함(이름을 검색하여 index를 찾는다)
				// 수정할 데이터를 입력받고 해당 객체에 다시 저장
				System.out.println("수정할 데이터의 이름 정보를 입력하세요");
				search = scan.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						// int searchindex = i;
						System.out.println("수정할 이름을 입력하세요");
						System.out.println("[취소 : exit]");
						name = scan.next();
						if (name.equals("exit")) {
							sclr();
							break;
						}
						System.out.println("수정할 번호를 입력하세요");
						System.out.println("[취소 : exit]");
						tel = scan.next();
						if (tel.equals("exit")) {
							sclr();
							break;
						}
						System.out.println("수정할 메모를 입력하세요");
						System.out.println("[취소 : exit]");
						memo = scan.next();
						if (memo.equals("exit")) {
							sclr();
							break;

						}
						// pb[searchindex].update(name,tel,memo);
						pb[i].update(name, tel, memo);
						System.out.println("번호가 수정되었습니다");
						System.in.read();
						sclr();
						break;
					}
					if (i == index - 1) {
						System.out.println("해당 이름을 가진 데이터가 없습니다");
						System.in.read();
						sclr();
						break;
					}
				}
				break;
			case 5:
				// 삭제는 먼저 데이터가 있는지를 확인해야 함(이름을 검색하여 index를 찾는다)
				// 삭제할 데이터를 입력받고 해당 객체에 공백을 저장
				System.out.println("삭제할 데이터의 이름 정보를 입력하세요");
				search = scan.next();
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						// int searchindex = i;
						name = "";
						if (name.equals("exit")) {
							break;
						}
						tel = "";
						if (tel.equals("exit")) {
							break;
						}
						memo = "";
						if (memo.equals("exit")) {
							break;

						}
						// pb[searchindex].update(name,tel,memo);
						pb[i].delete(name, tel, memo);
						System.out.println("번호가 삭제되었습니다");
						System.in.read();
						sclr();
						break;
					}
					if (i == index - 1) {
						System.out.println("해당 이름을 가진 데이터가 없습니다");
						System.in.read();
						sclr();
						break;
					}
				}
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				System.in.read();
				sclr();
				System.exit(0);
				break;
			}
		}
	};

	private static void sclr() {
		for (int i = 0; i < 80; i++) {
			System.out.println("");
		}
	}

	static void menu() {

		System.out.println("===================");
		System.out.println("    전화번호부 메뉴    ");
		System.out.println("===================");
		System.out.println("    1. 번호 입력");
		System.out.println("    2. 전체 출력");
		System.out.println("    3. 번호 검색");
		System.out.println("    4. 번호 수정");
		System.out.println("    5. 번호 삭제");
		System.out.println("===================");
		System.out.println("    0. 종료");
		System.out.println("===================");

	}

}
