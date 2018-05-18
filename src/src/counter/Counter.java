package counter;

public class Counter extends Thread {
	volatile static int cnt1 = 0;
	volatile static int cnt2 = 5;
	private final Object monitor;

	Counter(Object monitor) {
		this.monitor = monitor;
	}

	public static void main(String[] args) {
		final Object monitor = new Object();
		Counter c1 = new Counter(monitor);
		c1.start();
		Counter c2 = new Counter(monitor);
		c2.start();
		Counter c3 = new Counter(monitor);
		c3.start();
		Counter c4 = new Counter(monitor);
		c4.start();
	}

	public void run() {
		while (cnt1 < 5 && cnt2 < 10) {
			synchronized (this.monitor) {
				System.out.println(Thread.currentThread().getName() + " " + ++cnt1 + " " + ++cnt2);
			}
		}
	}
}
