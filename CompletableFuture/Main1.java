package CompletableFuture;

import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        // thenCompose() and thenComposeAsync()
        CompletableFuture<String> compFutureObj = CompletableFuture.supplyAsync(() -> {
            return "Hello";
          },poolExecutor)
                .thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> val + " World");
        })
                .thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> val + " all");
        });


        try {
            System.out.println(compFutureObj.get());

        }catch (Exception e){

        }

       // thenAccept and thenAcceptAsync
        CompletableFuture<String> compFutureOb1 = CompletableFuture.supplyAsync(() -> {
            return "Code";
        },poolExecutor);

        CompletableFuture<Void> competingfeture = compFutureOb1.thenAccept((String val) -> {
            System.out.println("Printing the value of : " + val);
        });


        try {

            System.out.println(competingfeture.get());

        }catch (Exception e){

        }
    }
}
