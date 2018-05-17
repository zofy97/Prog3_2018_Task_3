package primeNumber;

public class ThreadDemo {
	public static class T1 extends Thread	{
		public void run() {
			while(true)
				System.out.println("T1");
		}
		
		public static class T2 implements Runnable	{
			public void run()	{
				while(true)
					System.out.println("T2");
			}
		}
		
		public static void main(String[] args) {
			T1 t1 = new T1();
			t1.start();
			T2 t2 = new T2();
			Thread t = new Thread(t2);
			t.start();
		}
	}
}
