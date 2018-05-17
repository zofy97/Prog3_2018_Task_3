package primeNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException	{
		try(Scanner s = new Scanner(System.in))	{
			boolean run = true;
			List<ThreadedInterruptablePrimeNumberTools> threads = new ArrayList<>();
			while(run)	{
				System.out.println("Enter number, x [number] or x for exit: ");
				String txt = s.nextLine();
				if(txt.equals("x")) {
					for(Thread t : threads) {
						if(t.isAlive())	{
							run = false;
							System.out.println("There are still running threads. Are you sure you want to terminate? yes / no ");
							Scanner scan = new Scanner(System.in);
							String choice = scan.next();
							if(choice.equals("yes")) {
								for(Thread t2 : threads) {
									t2.interrupt();
								}
							}
						}
					}
				}
				else	{
					ThreadedInterruptablePrimeNumberTools tipt = new ThreadedInterruptablePrimeNumberTools(Integer.parseInt(txt));
					threads.add(tipt);
					tipt.start();
				}
			}
			for(Thread t : threads)
				try {
					t.join(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("all calculations done");
		}
	}
}
