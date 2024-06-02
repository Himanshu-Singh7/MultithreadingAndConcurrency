public class MonitorLockExample {
    public synchronized  void task1(){
        try {
            System.out.println("Inside the task 1 : ");
            Thread.sleep(10000);
            System.out.println("task 1 is completed");
        }catch ( Exception e){
        }
    }

    public void  task2(){
        System.out.println("task 2 : But before synchronize :");
        synchronized (this){
            System.out.println("task 2 : But After synchronize : ");
        }
    }

    public void task3(){
        System.out.println("task3 is : " );
    }

}
