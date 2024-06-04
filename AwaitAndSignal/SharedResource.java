package AwaitAndSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void produce(){
        try{
          lock.lock();
            System.out.println("Produce Lock acquire by :"+ Thread.currentThread().getName());
            if (isAvailable){
                // already available thread is wait for consume
                System.out.println("Produce is waiting :" + Thread.currentThread().getName());
                condition.await();
            }

            isAvailable = true;
            condition.signal();

        }catch (Exception e){
            // Handle exception here
        }finally {
            lock.unlock();
            System.out.println("Produce lock released by :" + Thread.currentThread().getName());
        }


    }
    public void consume(){
     try {
         Thread.sleep(8000);
         lock.lock();

         if (!isAvailable){
             // already is not available , thread has waited for producer
             System.out.println("Consume lock acquire by : " + Thread.currentThread().getName());
             condition.await();
         }
         isAvailable = false;
         condition.signal();

     }catch (Exception e){

     }finally {
         lock.unlock();
         System.out.println("Consume Released by :" + Thread.currentThread().getName());
     }
    }
}
