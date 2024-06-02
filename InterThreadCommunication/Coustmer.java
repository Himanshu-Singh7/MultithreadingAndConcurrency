package InterThreadCommunication;

public class Coustmer {
    int amount = 10000;
    public synchronized  void withdraw(int amount){
        System.out.println("going to withdraw...");

        if(this.amount < amount ){
            System.out.println("Less balance; waiting for deposit...");
        }
        try {
            wait();
        }catch (Exception e){

        }
     this.amount -= amount;
        System.out.println("Withdraw is completed");
    }
    public synchronized  void deposite(int amount){
        System.out.println("going to deposit..");
        this.amount += amount;
        System.out.println("deposit completed... ");
        notify();
    }
}
