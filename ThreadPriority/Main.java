package ThreadPriority;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        System.out.println("Main thread is stated");
        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 is calling produce method ");
            resource.produce();
        });
        // 1: means low Priority
        // 10: means highest Priority

        th1.setPriority(Thread.MAX_PRIORITY);
        th1.start();
        try{
            System.out.println("Main  thread is waiting for thread 1 to finish");
            th1.join();
        }catch (Exception e){
            // handle exception here
        }
        System.out.println("Main thread finished its work");

    }
}
