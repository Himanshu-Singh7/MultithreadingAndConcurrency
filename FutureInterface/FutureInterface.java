package FutureInterface;


import java.util.concurrent.*;
public class FutureInterface {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS ,new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureobj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("This is a task ,which thread will be execute :");
            }catch (Exception e){
                // Handle exception here
            }
        });

        System.out.println(futureobj.isDone());

        try {
            futureobj.get(2 , TimeUnit.SECONDS);
        }catch (TimeoutException | InterruptedException | ExecutionException e){
            System.out.println("Time out Exception occur ");
        }

        try {
            futureobj.get();
        }catch (Exception e){

        }
        System.out.println("is Done : "+futureobj.isDone());
        System.out.println("is cancelled :  "+ futureobj.isCancelled());
    }
}
