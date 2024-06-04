package StampedLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(() -> {
            resource.produce();
        });

        Thread th2 = new Thread(() -> {
            resource.consumer();
        });

        th1.start();
        th2.start();
    }
}
