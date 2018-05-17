package primeNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)	{
		List<Integer> numbers = new ArrayList<>();
		try(Scanner s = new Scanner(System.in))	{
			boolean run = true;
			List<ThreadedInteruptablePrimeNumberTools> threads = new ArrayList<>();
			while(run)	{
				System.out.println("Enter number, x [number] or x for exit: ");
				String txt = s.nextLine();
				if(txt.equals("x")) {
					for (Thread t : threads) {
						if (t.isAlive()) {
							run = false;
							System.out.println("There are still running threads. Are you sure you want to terminate? yes / no ");
							Scanner scan = new Scanner(System.in);
							String choice = scan.next();
							if (choice.equals("yes")) {
								for (Thread t2 : threads) {
									t2.interrupt();
								}
							}
						} else {
							run = false;
							System.exit(0);
						}
					}
				} else if (txt.equals("x ")) {
					run = false;
					System.exit(0);
				} else	{
					int x = Integer.parseInt(txt);
					for (int n : numbers)	{
						if (n == x)	{

						}
					}
					numbers.add(x);
					ThreadedInteruptablePrimeNumberTools tipt = new ThreadedInteruptablePrimeNumberTools(Integer.parseInt(txt));
					threads.add(tipt);
					synchronized (tipt) {
						tipt.start();
					};
				}
			}
			for(Thread t : threads) t.interrupt();
			System.out.println("all calculations done");
		}
	}
}
