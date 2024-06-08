package CallebleInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS ,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // Use case 1 : using runnable
        Future<?> futureobj1 = poolExecutor.submit(() -> {
            System.out.println("Task1 is runnabble :");

        });

        try {
            Object object = futureobj1.get();
            System.out.println(object == null);

        }catch (Exception e){

        }

        // Use case 2 : using callable

        List<Integer> optput = new ArrayList<>();
        Future<List<Integer>> futureobj2 = poolExecutor.submit(() -> {
           optput.add(100);
           System.out.println("Task 2 with runnable and Return Object");

        },optput);
       try {
           List<Integer> outputfromFutureObject2 = futureobj2.get();
           System.out.println(outputfromFutureObject2.get(0));

       }catch (Exception e){

       }
    }
}
