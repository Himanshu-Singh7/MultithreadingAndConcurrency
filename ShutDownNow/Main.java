package ShutDownNow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService poolobj = Executors.newFixedThreadPool(5);
        poolobj.submit(() -> {
         try {
             Thread.sleep(15000);
         }catch (Exception e){

         }
            System.out.println("Task completed");
        });
        poolobj.shutdownNow();
        System.out.println("Main thread is completed  : " + Thread.currentThread().getName());
    }
}
