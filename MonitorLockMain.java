public class MonitorLockMain {
    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();

        MonitorLockThread1 lockThread1 = new MonitorLockThread1(obj);


        Thread t1 = new Thread(lockThread1);
        Thread t2 = new Thread(() -> {obj.task2();});
        Thread t3 = new Thread(() -> {obj.task3();});

        t1.start();
        t2.start();
        t3.start();
    }
}
