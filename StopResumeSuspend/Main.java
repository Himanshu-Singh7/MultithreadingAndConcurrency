package StopResumeSuspend;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        System.out.println("Main thread started : ");

        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 calling produced method");
            resource.produce();
        });

        Thread th2 = new Thread(() -> {
          try {
              Thread.sleep(1000);
          }catch (Exception e){
              // handle exception here

          }
            System.out.println("Thread 2 calling produced method");
          resource.produce();
        });

        th1.start();
        th2.start();

        try {
            Thread.sleep(3000);
        }catch (Exception e){
            // handle exception here

        }
        System.out.println("Thread 1 suspended");
        th1.suspend();
//        try {
//            Thread.sleep(3000);
//        }catch (Exception e){
//            // handle exception here
//
//        }
//        th1.resume();
        System.out.println("Main thread is finishing its work");
    }
}
