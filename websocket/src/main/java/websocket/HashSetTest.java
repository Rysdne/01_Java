package websocket;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		// Set은 인터페이스
		Set<String> set = new HashSet<String>();
		set.add("apple");
		set.add("banana");
		set.add("kiwi");
		
		set.remove("apple");

		System.out.println(set.toString());
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
