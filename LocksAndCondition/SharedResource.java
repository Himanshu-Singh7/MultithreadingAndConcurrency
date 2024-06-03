package LocksAndCondition;

public class SharedResource {

    boolean isAvailable = false;

    public synchronized void produce(){


        try {
            System.out.println("Lock Acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        }catch (Exception e){

        }
        System.out.println("Lock released by: " + Thread.currentThread().getName());
    }
}
