package socket220801;

class MyThread extends Thread {
	private int num;
	private String name;

	public MyThread(String a, int b) {
		name = a;
		num = b;
	}

	public void run() { // Callback 메소드
		for (int i = 0; i < num; i++)
			System.out.println(name + " : " + i);
	}
}

public class ThreadTest1 {
	public static void main(String args[]) throws InterruptedException {
		MyThread t1 = new MyThread("first", 100);
		MyThread t2 = new MyThread("second", 100);
		MyThread t3 = new MyThread("third", 100);

		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(1000);
		t2.stop();

	}
}
