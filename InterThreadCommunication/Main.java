package InterThreadCommunication;

public class Main {
    public static void main(String[] args) {
         Coustmer coustmer = new Coustmer();

         Thread withdrawl = new Thread(new WithdrawRunnable(coustmer));
         Thread deposite = new Thread(new DepositeRunnable(coustmer));
         withdrawl.start();
         deposite.start();

    }
}
