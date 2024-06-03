package ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void produce(ReentrantLock lock){

        try {
            lock.lock();
            System.out.println("Lock Acquired By: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        }catch (Exception e ){
            // Handle exception here
        }finally {
            lock.unlock();
            System.out.println("Lock Released By:" + Thread.currentThread().getName());
        }

    }
}
