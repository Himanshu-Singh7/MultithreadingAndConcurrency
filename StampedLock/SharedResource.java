package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();
    public void produce(){
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic read");
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("Update the value successfully");
            }else {
                System.out.println("Roll back your work");
                a = 10; //rollback
            }
        }catch (Exception e){

        }
    }
    public void consumer(){
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by :" + Thread.currentThread().getName());
        try {
            System.out.println("Performing work");
            a = 9;
        }finally {
            lock.unlockWrite(stamp);
            System.out.println("write lock released by :"+ Thread.currentThread().getName());
        }
    }
}
