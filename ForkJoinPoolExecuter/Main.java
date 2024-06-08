package ForkJoinPoolExecuter;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> futureobj = pool.submit(new ComputeSumTask(0, 100));
        try {
            System.out.println(futureobj.get());
        }catch (Exception e){
            // handle exception here
        }
    }
}
