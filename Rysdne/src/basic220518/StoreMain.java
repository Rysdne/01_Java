package basic220518;
//가게를 만들려고 합니다.
//가게에 필요한 사항은 가게이름(name), 아이템(item), 설립자금(capital)
//가게 홍보를 위해 가게이름을 출력하는 함수(print)
class Store{
	String name;
	String item;
	int capital;
	
	Store(String name, String item, int capital){
		this.name=name;
		this.item=item;
		this.capital=capital;
	}
	void print() {
		System.out.println("가게이름:"+name);
	}
}
public class StoreMain {

	public static void main(String[] args) {
		//가게 클래스를 만들 후 3개의 가게를 만들고
		Store s1=new Store("꽂가게","꽂",100);
		s1.print();
		Store s2=new Store("라면가게","라면",200);
		s2.print();
		Store s3=new Store("햄버거가게","햄버거",300);
		s3.print();
		//가게를 모두 홍보합니다.
		//가게를 만들 때 배열을 이용합니다.
		Store[] stores=new Store[3];
		stores[0]=new Store("꽂가게","꽂",100);
		stores[1]=new Store("라면가게","라면",200);
		stores[2]=new Store("햄버거가게","햄버거",300);
		
		for(Store s:stores) {
			s.print();
		}
	}

}
