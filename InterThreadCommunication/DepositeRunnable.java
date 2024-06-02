package InterThreadCommunication;

public class DepositeRunnable implements  Runnable{
    Coustmer coustmer;
    DepositeRunnable(Coustmer coustmer){
        this.coustmer = coustmer;
    }

    @Override
    public void run() {
        coustmer.deposite(10000);
    }
}
