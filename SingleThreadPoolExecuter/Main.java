package SingleThreadPoolExecuter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    // 'newSingleThreadExecutor' Executor has just single Worker Thread
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> submit = executorService.submit(() -> "this is the Async task");
        try {
            System.out.println(submit.get());
        }catch (Exception e){

        }
    }
}
