package FixedThreadPoolexecuter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        //'newFixedThreadPool' method creates a thread pool Executor with a fixed no of Thread.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> submit = executorService.submit(() -> "this is the Async task");

        try {

            System.out.println(submit.get());
        }catch (Exception e){
            // Handle exception here
        }
    }
}
