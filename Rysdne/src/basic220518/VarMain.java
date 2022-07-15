package basic220518;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class VarMain {

	public static void main(String[] args) {
		//List<String> test=new ArrayList<String>();
		ArrayList<String> arraylist=new ArrayList<String>();
		List<String> list=new Vector<String>();
		arraylist.add("1번");
		arraylist.add("2번");
		arraylist.add("3번");
		//List<String> list=test;
		
		//list=arraylist
		if(list instanceof ArrayList) {
		System.out.println("check");
		list=arraylist;
		}
		
		System.out.println("list"+list);
		for(String s : list) {
			System.out.println(s);
		}
		/*
		test.add("1번");
		test.add("2번");
		test.add("3번");
		for(String s : test) {
			System.out.println(s);
		}
		*/
		/*
		String s="hello";
		String s1="hello1";
		char c='a';
		ArrayList list=new ArrayList();
		System.out.println("list1:"+ (list instanceof ArrayList) );
		System.out.println("list2:"+ (list instanceof List) );
		System.out.println("list3:"+ (list instanceof Set) );
		*/
		
		//System.out.println("String:" + (s instanceof String));
		//System.out.println("String:"+s instanceof char);
		//System.out.println(s instanceof s1);
		//boolean b=true;
		//b=1;
		/*
		int A;
		int a;
		int _a;
		int $a;
		*/
		//int a@;
		//int 1a;
		//int a1;
		//final int z=100;
		//int final zz=10;
		//System.out.println();
		//z=1000;
		
		/*
		System.out.println("hello java");
		System.out.println(args[0]);
		System.out.println(args[1]);
		*/
		/*
		short s=10; //2byte 0~+32*1024=32000
		int i=100; //4byte
		System.out.println("s:"+s+ ",i:"+i);
		s=i;
		i=s;
		*/
		
		/*
		System.out.println("byte형 비트크기:"+Byte.SIZE); //1byte
		System.out.println("Byte형 바이트크기:"+Byte.BYTES);
		
		System.out.println("short형 비트크기:"+Short.SIZE); //1byte
		System.out.println("short형 바이트크기:"+Short.BYTES);
		
		System.out.println("int형 비트크기:"+Integer.SIZE); //1byte
		System.out.println("int형 바이트크기:"+Integer.BYTES);
		
		//long-Long, float-Float, double-Double
	*/
	}

}
