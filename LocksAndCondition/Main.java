package LocksAndCondition;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();


        Thread th1 = new Thread(() -> {
            resource1.produce();
        });

        SharedResource resource2 = new SharedResource();
        Thread th2 = new Thread(() -> {
            resource2.produce();
        });
        th1.start();
        th2.start();


    }
}
