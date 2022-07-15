package basic220516;

import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

public class VarMain {

	public static void main(String[] args) {

		// List<String> test=new ArrayList<String>();
		ArrayList<String> test = new ArrayList<String>();
		// List<String> list=test;
		List<String> list = new ArrayList<String>();
		if (list instanceof ArrayList) {
			System.out.println("check");
			list = test;
		}
		System.out.println("list : " + list);
		// for (String s : list) {
		// }

		/*
		 * list.add("1번째"); list.add("2번째"); list.add("3번째"); for (String s : list) {
		 * System.out.println(s); }
		 */

		/*
		 * test.add("1번째"); test.add("2번째"); test.add("3번째"); for(String s:test) {
		 * 
		 * System.out.println(s);
		 * 
		 * }
		 */

		/*
		 * String s="hello"; String s1="hello1"; char c='a'; ArrayList list=new
		 * ArrayList(); System.out.println("list1 : "+(list instanceof ArrayList));
		 * System.out.println("list2 : "+(list instanceof List));
		 * System.out.println("list3 : "+(list instanceof Set));
		 */

		// System.out.println(s instanceof c);
		// System.out.println(s instanceof s1);

	}

}
