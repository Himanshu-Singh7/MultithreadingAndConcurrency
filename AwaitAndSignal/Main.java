package AwaitAndSignal;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(() -> {
            for (int i = 0 ; i< 2 ; i++){
                resource.produce();
            }
        });

        Thread th2 = new Thread(() -> {
            for(int i = 0 ; i < 2 ; i++){
                resource.consume();
            }
        });

        th1.start();
        th2.start();
    }
}
