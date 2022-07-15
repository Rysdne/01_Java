package pb220526;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TotalPhoneBookMain {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		PhoneBook[] pb = new PhoneBook[100];
		int index = 0; // 저장할 위치 초기값
		int select = 0; // 메뉴번호를 선택하기 위한 초기값
		String search = null;
		String name = null;
		String tel = null;
		String memo = null;

		// 파일로부터 데이터 로드
		// =================== File Upload ===================

		File f00 = new File("phonebook.txt");
		FileReader f01 = new FileReader(f00);
		BufferedReader f02 = new BufferedReader(f01);

		// txt 변수 선언
		String txt = null;

		// 파일로부터 반복해서 줄 읽기
		while ((txt = f02.readLine()) != null) {

			// 문자를 parsing하여 배열에 저장
			String arr[] = txt.split(" ");
			// ...............................................

			// 배열에 parsing한 데이터를 저장
			pb[index] = new PhoneBook(arr[0], arr[1], arr[2]);

			// i를 1씩 증가시켜 저장 공간마다 데이터 입력
			index++;
		}
		// 로드 스트림을 닫아줘야 또 사용 가능
		f02.close();
		f01.close();

		// ===================================================

		while (true) {

			menu();
			select = scan.nextInt();

			// 화면 클리어 함수 생성, 근데 줄을 줄을 밀어내는걸로 하는거라 야매임
			// sclr();

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
				pb[index++] = new PhoneBook(name, tel, memo);
				System.out.println("번호가 추가되었습니다");
				System.in.read();
				// sclr();
				break;

			case 2:
				if (index < 1) {
					System.out.println("조회할 데이터가 없습니다");
					System.in.read();
					// sclr();
					break;
				} else {
					for (int i = 0; i < index; i++) {
						if (pb[i] != null) {
							pb[i].view();
						}
					}
				}
				System.in.read();
				break;

//				for (int i = 0; i < index; i++) {
//					if (pb[i] != null) {
//
//						pb[i].view();
//					}
//				}
//				System.in.read();
//				break;

			case 3:
				System.out.println("검색할 이름을 입력하세요");
				System.out.println("[취소 : exit]");
				search = scan.next();
				if (search.equals("exit")) {
					break;
				}
				// 저장공간을 의미하는 i가 index(저장된 최대치+1)보다 작은 수가 될 때까지 반복
				for (int i = 0; i < index; i++) {
					// if) pb[i]에 저장된 값이 입력한 name 값과 동일한가
					if (search.equals(pb[i].name)) {
						pb[i].view();
						System.in.read();
						// sclr();
						break;
					}
					// if) pb[i]에 저장된 값이 입력한 name 값과 동일하지 않고(break), i가 index(저장된 최대치+1)-1일 경우
					// -> 모든 공간을 다 봤는데도 동일한 name 값이 없는 경우
					if (i == index - 1) {
						System.out.println("해당 이름을 가진 데이터가 없습니다");
						System.in.read();
						// sclr();
						break;
					}
				}
				break;

			case 4:
				// 수정은 먼저 데이터가 있는지를 확인해야 함(이름을 검색하여 index를 찾는다)
				// 수정할 데이터를 입력받고 해당 객체에 다시 저장
				System.out.println("수정할 데이터의 이름 정보를 입력하세요");
				System.out.println("[취소 : exit]");
				search = scan.next();
				if (search.equals("exit")) {
					break;
				}
				for (int i = 0; i < index; i++) {
					if (search.equals(pb[i].name)) {
						// int searchindex = i;
						System.out.println("수정할 이름을 입력하세요");
						System.out.println("[취소 : exit]");
						name = scan.next();
						if (name.equals("exit")) {
							// sclr();
							break;
						}
						System.out.println("수정할 번호를 입력하세요");
						System.out.println("[취소 : exit]");
						tel = scan.next();
						if (tel.equals("exit")) {
							// sclr();
							break;
						}
						System.out.println("수정할 메모를 입력하세요");
						System.out.println("[취소 : exit]");
						memo = scan.next();
						if (memo.equals("exit")) {
							// sclr();
							break;

						}
						// pb[searchindex].update(name,tel,memo);
						pb[i].update(name, tel, memo);
						System.out.println("번호가 수정되었습니다");
						System.in.read();
						// sclr();
						break;
					}
					if (i == index - 1) {
						System.out.println("해당 이름을 가진 데이터가 없습니다");
						System.in.read();
						// sclr();
						break;
					}
				}
				break;

			case 5:
				// 삭제는 먼저 데이터가 있는지를 확인해야 함(이름을 검색하여 index를 찾는다)
				// 삭제할 데이터를 입력받고 해당 객체에 공백을 저장
				System.out.println("삭제할 데이터의 이름 정보를 입력하세요");
				System.out.println("[취소 : exit]");
				search = scan.next();
				if (search.equals("exit")) {
					break;
				}
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
						// sclr();
						break;
					}
					if (i == index - 1) {
						System.out.println("해당 이름을 가진 데이터가 없습니다");
						System.in.read();
						// sclr();
						break;
					}
				}
				break;

			case 6:

				// 파일로부터 데이터 로드
				// =================== File Upload ===================

				System.out.println("불러올 파일명을 입력하세요");
				System.out.println("[취소 : exit]");
				String filename = scan.next();
				if (filename.equals("exit")) {
					break;
				}
				// 앞에서 초기화가 되어있기 때문에 새로 선언할 필요는 없음
				// f00 부분에서 오류메시지가 계속 있어서 좀 이상했는데 저장하니 사라짐
				f00 = new File(filename);

				// 파일이 있는지부터 알아보기
				if (!f00.exists()) {
					System.out.println("해당 파일을 찾을 수 없습니다");
					System.in.read();
					break;
				}

				f01 = new FileReader(f00);
				f02 = new BufferedReader(f01);
				// txt 변수 선언
				txt = null;

				// 인덱스 할 index를 0으로 초기화
				index = 0;
				// pb[100] 객체배열을 null 값으로 초기화
				// readLine() 함수에서는 i를 초기화할 수 없기 때문에 별도로 선언

				// 파일로부터 반복해서 줄 읽기
				for (int k = 0; k < pb.length; k++) {
					pb[k] = null;
				}
				while ((txt = f02.readLine()) != null) {

					// 문자를 parsing하여 배열에 저장
					String arr[] = txt.split(" ");
					// ...............................................

					// 배열에 parsing한 데이터를 저장
					pb[index] = new PhoneBook(arr[0], arr[1], arr[2]);

					// i를 1씩 증가시켜 저장 공간마다 데이터 입력
					index++;
				}
				System.out.println("데이터 로드 완료!");
				System.in.read();
				// sclr();

				// 로드 스트림을 닫아줘야 또 사용 가능
				f02.close();
				f01.close();
				f00 = new File("phonebook.txt");
				break;

			// ===================================================

			case 7: // 데이터 세이브

				FileWriter f11 = new FileWriter(f00);
				BufferedWriter f12 = new BufferedWriter(f11);

//				// =======================================================
//				
//				// 1. 엔터키 신경 안쓰고 하기
//				// 메모리에서 파일로 저장하는 반복문 생성
//				for (int c = 0; c < index; c++) {
//					// str 변수를 선언하여 입력할 라인 생성
//					// str 변수를 밖에 선언하고 +=로 중첩시키는 방법도 있음, 그러나 결과적으로는 안됨
//
//					// 내용이 ""가 아닌 경우에만 저장
//					if (!pb[c].name.equals("")) {
//						String str = pb[c].name + " " + pb[c].tel + " " + pb[c].memo + "\n";
//						// 마지막에 줄바꿈이 꼭 있어야 함
//						System.out.println(str);
//						// str 저장 : 줄 단위로 쓰기 때문에 +=로 데이터를 중첩시켜놔도 한 줄만 입력됨
//						f12.write(str);
//						// flush : 밀어넣기, 이 놈이 있어야 이전 데이터가 사라지지 않음
//						f12.flush();
//					}
//				}
//				f12.close();
//				f11.close();
//				break;
//				// ...............................................

				// 2. 마지막에는 엔터를 쓰지 않음
				// 1) 문장의 앞에 엔터를 치고 제일 처음에는 엔터 없게 함
				// 2) 문장의 맨 뒤에 엔터를 치지 않음 -> c==(index-1)일 경우를 사용

				// 나는 1번 사용함
				// 마지막에 \n을 저장하지 말아야 함
				// 메모리에서 파일로 저장하는 반복문 생성
				for (int c = 0; c < index; c++) {
					// str 변수를 선언하여 입력할 라인 생성
					// str 변수를 밖에 선언하고 +=로 중첩시키는 방법도 있음, 그러나 결과적으로는 안됨

					// 내용이 ""가 아닌 경우에만 저장
					if (c == (index - 1)) {
						if (!pb[c].name.equals("")) {
							String str = pb[c].name + " " + pb[c].tel + " " + pb[c].memo;
							// 마지막에 줄바꿈이 꼭 있어야 함
							// System.out.println(str);
							// str 저장 : 줄 단위로 쓰기 때문에 +=로 데이터를 중첩시켜놔도 한 줄만 입력됨
							f12.write(str);
							// flush : 밀어넣기, 이 놈이 있어야 이전 데이터가 사라지지 않음
							f12.flush();
						}
					} else {
						if (!pb[c].name.equals("")) {
							String str = pb[c].name + " " + pb[c].tel + " " + pb[c].memo + "\n";
							// 마지막에 줄바꿈이 꼭 있어야 함
							// System.out.println(str);
							// str 저장 : 줄 단위로 쓰기 때문에 +=로 데이터를 중첩시켜놔도 한 줄만 입력됨
							f12.write(str);
							// flush : 밀어넣기, 이 놈이 있어야 이전 데이터가 사라지지 않음
							f12.flush();
						}
					}
				}
				System.out.println("데이터 세이브 완료!");
				System.out.println("\"phonebook.txt\"에 저장되었습니다");
				System.in.read();
				// sclr();
				f12.close();
				f11.close();
				break;

			// =======================================================

			case 0:
				System.out.println("프로그램을 종료합니다");
				System.in.read();
				// sclr();
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

		System.out.println("====================");
		System.out.println("    전화번호부 메뉴    ");
		System.out.println("====================");
		System.out.println("    1. 번호 입력");
		System.out.println("    2. 전체 출력");
		System.out.println("    3. 번호 검색");
		System.out.println("    4. 번호 수정");
		System.out.println("    5. 번호 삭제");
		System.out.println("    6. 데이터 로드");
		System.out.println("    7. 데이터 세이브");
		System.out.println("====================");
		System.out.println("    0. 종료");
		System.out.println("====================");

	}

}
