package ThreadLocal;

public class Main {
    public static void main(String[] args) {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();

        Long userId1 = 7372L;
        Long userId2 = 5673L;

        Thread th1 = new Thread(() ->{
            System.out.println("Started thread for : "+ userId1);
            threadLocal.set(userId1);
            // Process of Logic
            // Database Call
            System.out.println("Complete the Logic :" + threadLocal.get());
            // Good coding pratice to remove threadlocal object
            threadLocal.remove();
            System.out.println("Removed the Object : " + threadLocal.get());
        });


        Thread th2 = new Thread(()-> {
            System.out.println("Started thread for :"+ userId2);
            threadLocal.set(userId2);
            // Process of Logic
            // Database Call
            System.out.println("Complete the Logic :" + threadLocal.get());
            // Good coding pratice to remove threadlocal object
            threadLocal.remove();
            System.out.println("Removed the Object :" +threadLocal.get());
        });

     th1.start();
     th2.start();
    }
}
