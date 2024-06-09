package SecheduledthreadPoolExecutor;


import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    //SchedulerThreadPoolExecutor : It helps to schedule the Tasks
    public static void main(String[] args) {
        ScheduledExecutorService poolobj = Executors.newScheduledThreadPool(5);

        // 1 : schedule(Runnable command,long delay,TimeUnit unit):-Schedule a Runnable task after specif delay.Only one time task run.
        poolobj.schedule(()  -> {
            System.out.println("Hello");
        } , 5 , TimeUnit.SECONDS);

        // 2 : schedule(Callable<V> callable,long delay,TimeUnit unit) :Schedule a Callable task after specif delay.Only one time task run.
       Future<String> futureobj1 = poolobj.schedule(() -> {
           return "Hello";
        }, 5 , TimeUnit.SECONDS);

       try {
           System.out.println(futureobj1.get());
       }catch (Exception e){

       }



    }
}
