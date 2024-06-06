package ThreadPoolExecuter;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10,TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),new CustumThreadfactory(), new ThreadPoolExecutor.DiscardPolicy());

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