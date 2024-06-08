package CachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
       // 'newCachedThreadPool' we can use for sort lived task , that create a new thread we needed(Dynamically)
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(() -> "this is the Async task");
        try {
            System.out.println(submit.get());
        }catch (Exception e){

        }
    }
}
