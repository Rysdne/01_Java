package basic220518;
class Pay{
	private String name;
	public int bonbong;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class PayMain {

	public static void main(String[] args) {
		Pay pay=new Pay();
		//pay.name="홍길동";
		pay.setName("홍길동");
		//System.out.println(pay.name);
		//System.out.println(pay.getName());
		
		pay.bonbong=100000;

	}

}
