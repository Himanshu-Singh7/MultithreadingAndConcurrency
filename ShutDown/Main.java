package ShutDown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService poolobj = Executors.newFixedThreadPool(5);
        poolobj.submit(() -> {
            try {
                Thread.sleep(5000);

            }catch (Exception e){

            }
            System.out.println("Task completed");
        });
        poolobj.shutdown();
        System.out.println("Main Thread is competed");

    }
}
