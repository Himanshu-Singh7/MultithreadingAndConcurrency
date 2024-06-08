package CallebleInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,3,1, TimeUnit.HOURS ,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        List<Integer> output = new ArrayList<>();

        Future<List<Integer>> futureObject = poolExecutor.submit(new MyRunnable(output), output);
        try {
            futureObject.get();
            // 1 way
            System.out.println(output.get(0));
            // 2 way
           List<Integer> result = futureObject.get();
            System.out.println(result.get(0));
        }catch (Exception e){

        }


    }
}
