package primeNumber;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args)	{

		final Object monitor = new Object();

		try(Scanner s = new Scanner(System.in))	{
			boolean run = true;
			List<ThreadedInteruptablePrimeNumberTools> threads = new ArrayList<>();
			ConcurrentHashMap primeFactors = new ConcurrentHashMap();
			while(run)	{
				System.out.println("Enter number, x [number] or x for exit: ");
				String txt = s.nextLine();
				if(txt.equals("x") || txt.equals("x ")) {
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
						}
					}
					run = false;
					System.exit(0);
				} else if (txt.contains("x ")) {
					String newtxt = txt.substring(3);
					Integer.parseInt(newtxt);
					for (Thread t : threads)	{
						if (t.equals(Integer.parseInt(newtxt)))	{
							if (t.isAlive())	{
								run = false;
								System.out.println("This threads is still running. Are you sure you want to terminate? yes / no ");
								Scanner scan = new Scanner(System.in);
								String choice = scan.next();
								if (choice.equals("yes")) {
									for (Thread t2 : threads) {
										t2.interrupt();
									}
								}
							}
						}
					}
				} else if (txt == "")	{
					System.out.println("Please enter a valid input");
				} else {
					if(primeFactors.containsKey(txt)) {
                        System.out.print("primeFactors(" + txt + ") = \n");
                        System.out.println(primeFactors.get(txt));
                    } else {
                            ThreadedInteruptablePrimeNumberTools tipt = new ThreadedInteruptablePrimeNumberTools(Integer.parseInt(txt));
                            threads.add(tipt);
                            new Thread(tipt).start();
                            synchronized (monitor) {
                                primeFactors.put(txt, tipt.printPrimeFactors(Integer.parseInt(txt)));
                                tipt.sleep(100);
                            }
					}
				}
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
