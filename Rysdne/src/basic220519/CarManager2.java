package basic220519;

public class CarManager2 {

	public static void main(String[] args) {
		// CarInfo에서 함수를 불러올 수 있음
		// 다른 페이지에서 CarInfo()를 불러오기 위해서는 원본에서 기본 생성자인 CarInfo(){}를 만들어줘야 함

		/*
		 * // CarInfo() 함수를 호출하여 객체화, 값 초기화 CarInfo ci = new CarInfo("gv80", 3000, 100,
		 * 7, 300);
		 * 
		 * //CarInfo.carContents() 함수 호출 ci.carContents();
		 * 
		 * //CarInfo.buyInfo() 함수 호출 ci.buyInfo();
		 * 
		 * //CarInfo.buyChange() 함수 호출, 값 초기화 ci.buyChange("rysdne", "010-4313-8294");
		 * 
		 * //CarInfo.buyInfo() 함수 호출 ci.buyInfo();
		 */

		// CarInfo 함수를 호출하여 배열로 객체화, 값은 초기화하지 않고 저장 공간만 준비
		CarInfo[] ci = new CarInfo[10];

		for(int r=0;r<ci.length;r++) {
			ci[r]=new CarInfo("",0,0,0,0);
		}
		
		
		// 배열의 저장공간에 차 정보 함수를 호출, 객체화하여 등록
		ci[0] = new CarInfo("gv80", 3000, 100, 7, 300);
		ci[1] = new CarInfo("소나타", 3000, 100, 7, 300);
		ci[2] = new CarInfo("포터", 3000, 100, 7, 300);
		ci[3] = new CarInfo("코란도", 3000, 100, 7, 300);

		// 배열은 반복문을 쓸 수 있음
		for(int i=0;i<ci.length;i++) {
			ci[i].carContents();
		}
		
	}

}
