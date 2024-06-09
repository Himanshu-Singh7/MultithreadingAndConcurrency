package AwaitTermination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService poolobj = Executors.newFixedThreadPool(5);
        poolobj.submit(() -> {

            try {
                Thread.sleep(5000);
            }catch (Exception e){

            }
            System.out.println("Task Completed");
        });

        poolobj.shutdown();
        try {
            boolean terminated = poolobj.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("is Terminated : "+ terminated);
        }catch (Exception e){

        }
        System.out.println("Main Thread is completed : ");
    }
}
