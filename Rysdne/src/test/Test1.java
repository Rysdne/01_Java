package test;

public class Test1 {

	public static void main(String[] args) {
	
		int i=0;
		
		char star='*';
//		String phrase="";
//		for(;i<5;i++) {
//			phrase+=star;
//			System.out.println(phrase);
//		}
		
		i=0;
		int j=1;
		for(j=1;j<6;j++) {
			for(i=0;i<j;i++) {
				System.out.print(star);
			}
			System.out.println();
		}
		
		
		
		int sum=0;
		for(int k=1;k<=100;k++) {
			if(k%10!=0) {
			sum+=k;
			}
		}
		System.out.println(sum);
		
		
	}
	
}
