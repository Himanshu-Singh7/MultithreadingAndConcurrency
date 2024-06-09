package SecheduledthreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main1 {
    // 3 :scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit):-
    // * Schedule a Runnable task for repeated execution with fixed rate
    public static void main(String[] args) {

        ScheduledExecutorService threadpoolobj = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> futureobj = threadpoolobj.scheduleAtFixedRate(() -> {
            System.out.println("Thread picked the task");
            try {
                Thread.sleep(5000);
            }catch (Exception e){

            }
            System.out.println("Thread completed the task");
            }, 1, 3, TimeUnit.SECONDS);
        
    }
}
