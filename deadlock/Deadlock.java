package deadlock;

public class Deadlock {
    public static void main(String[] args)  {
        String r1 = "1";
        String r2 = "2";

        Thread t1 = new Thread()    {
            public void run()   {
                synchronized (r1)    {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(200);
                    } catch (Exception e)   {

                    }
                    synchronized (r2)    {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        /*
        Thread 1 locked r1 and waits to lock r2
        Thread 2 locked r2 and waits to lock r1
        both wait for the other one to unlock the resource
        but the can't until they get the other resource
         */
        Thread t2 = new Thread()    {
            public void run() {
                synchronized (r2) {
                    System.out.println("Thread 2: locked resource 2");
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                    }
                    synchronized (r1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
