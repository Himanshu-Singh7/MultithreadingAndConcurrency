package SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable = false;
    Semaphore lock = new Semaphore(3);

    public void produce(){
        try {
           lock.acquire();
           System.out.println("Lock acquired by : " + Thread.currentThread().getName());
           isAvailable = true;
           Thread.sleep(8000);
        }catch (Exception e){
            // handle exception here

        }finally {
            lock.release();
            System.out.println("Lock released by : " + Thread.currentThread().getName());
        }
    }

}
