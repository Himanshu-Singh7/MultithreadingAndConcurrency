package ThreadPoolExecuter;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),new CustumThreadfactory(), new CustumRejectedHandler());

        for(int i = 1 ; i <=4 ; i++){
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    // handle the exception here
                }
                System.out.println("Task processed by : "+ Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

class CustumThreadfactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }
}

class  CustumRejectedHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected :" + r.toString());
    }
}