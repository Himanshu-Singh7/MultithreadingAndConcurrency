package InterThreadCommunication;

public class WithdrawRunnable implements  Runnable{
    Coustmer coustmer;
    WithdrawRunnable(Coustmer coustmer){
        this.coustmer = coustmer;
    }


    @Override
    public void run() {
        coustmer.withdraw(15000);
    }
}
