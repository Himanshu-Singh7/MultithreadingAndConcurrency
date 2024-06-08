package CompletableFuture;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor  poolExecutor = new ThreadPoolExecutor(1, 1 , 1 , TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<String> asncTask1 = CompletableFuture.supplyAsync(() -> {

            return "Task Completed";
        }, poolExecutor);

        try {
            System.out.println(asncTask1.get());
        }catch (Exception e){

        }
        // thenApply : it  is a synchronous exception. Means it uses same thread which completed the previous task.

        CompletableFuture<String> asncTask2 = CompletableFuture.supplyAsync(() -> {
             try {
                 System.out.println("Thraed name of applying supplyAsync :" + Thread.currentThread().getName());
                 Thread.sleep(8000);
             }catch (Exception e){
                 // handle exception here
             }
            return "My name is Himanshu";
        }, poolExecutor).thenApply((String val) -> {
            System.out.println("Thread name of then apply : " + Thread.currentThread().getName());
            return val + " Singh";
        });

        try {
            System.out.println(asncTask2.get());
        }catch (Exception e){
           // handle exception here
        }


        // then applyAsync : it is Asynchronous execution : Means it uses different thread(from fork-join-pool,if we do not provide -
        // the executor the completed this function
        CompletableFuture<String> asncTask3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Thraed name of applying supplyAsync :" + Thread.currentThread().getName());
                Thread.sleep(7000);
            }catch (Exception e){
                // handle exception here
            }
            return "Coding and ";
        },poolExecutor).thenApplyAsync((String val) -> {
            System.out.println("Thread name of then apply : " + Thread.currentThread().getName());
            return val + " Concept";
        },poolExecutor);

        try {

            System.out.println(asncTask3.get());

        }catch (Exception e){

        }

    }
}
