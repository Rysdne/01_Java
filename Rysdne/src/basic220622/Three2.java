package basic220622;

import java.io.IOException;

public class Three2 {
	int c;

	public Three2() {
		try {
			c = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
