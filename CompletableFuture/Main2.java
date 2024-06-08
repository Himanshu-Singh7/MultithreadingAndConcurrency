package CompletableFuture;

import java.util.concurrent.*;

public class Main2 {

    // thenAccept() & theAcceptAsync() : Use to combine the result of 2 Completable future
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4 , 1 , TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            return 11;
        }, poolExecutor);


        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
            return "A";
        });

        CompletableFuture<String> combinefutureobj = asyncTask1.thenCombine(asyncTask2, (Integer val1, String val2) -> val1 + val2);
        try {
            System.out.println(combinefutureobj.get());
        }catch (Exception e){
            // handle exception here
        }
    }
}
