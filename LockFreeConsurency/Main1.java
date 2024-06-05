package LockFreeConsurency;

public class Main1 {
    public static void main(String[] args) {
     SharedResource resource = new SharedResource();

     Thread th1 = new Thread(() -> {
         for(int i = 0 ; i < 200 ; i++){
             resource.increment();
        }
     });

        Thread th2 = new Thread(() -> {
            for(int i = 0 ; i < 200 ; i++){
                resource.increment();
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        }catch (Exception e){
            // handle exception here
        }

        System.out.println(resource.get());
    }
}
