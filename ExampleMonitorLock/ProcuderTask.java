package ExampleMonitorLock;

public class ProcuderTask implements  Runnable{

    SharedResource sharedResource;

    ProcuderTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer Thread :" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000l);
        }catch (Exception e ){

        }
        sharedResource.addItem();
    }
}
