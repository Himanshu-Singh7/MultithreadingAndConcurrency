package DaemonThread;

public class Main {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        System.out.println("Main thread is stated");
        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 is calling produce method ");
            resource.produce();
        });

        th1.setDaemon(true);
        th1.start();
        System.out.println("Main thread finished its work");

    }
}
