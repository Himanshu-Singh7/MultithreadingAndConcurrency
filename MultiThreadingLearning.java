

public class MultiThreadingLearning implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread Name : " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("Inside the Main method : " + Thread.currentThread().getName());
        MultiThreadingLearning learning = new MultiThreadingLearning();
        Thread thread = new Thread(learning);
        thread.start();
        System.out.println("Finished Main method:" + Thread.currentThread().getName());
    }
}
