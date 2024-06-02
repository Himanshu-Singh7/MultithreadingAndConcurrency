public class MonitorLockThread1  implements  Runnable{
    MonitorLockExample obj;
    MonitorLockThread1(MonitorLockExample obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.task1();
    }
}
