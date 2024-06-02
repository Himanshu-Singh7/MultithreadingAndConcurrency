package ExampleMonitorLock;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Producer Thread
        Thread producerthread = new Thread(new ProcuderTask(sharedResource));
        // Consumer thread
        Thread consumerthread = new Thread(new ConsumerTask(sharedResource));

        producerthread.start();
        consumerthread.start();
    }
}
