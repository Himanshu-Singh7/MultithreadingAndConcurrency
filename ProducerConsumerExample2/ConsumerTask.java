package ProducerConsumerExample2;

public class ConsumerTask implements Runnable{
    SharedResourse sharedResourse;
    ConsumerTask(SharedResourse resourse){
        this.sharedResourse = resourse;
    }

    @Override
    public void run() {
    try {
        for(int i = 0 ; i < 6 ; i++){
            sharedResourse.consumer();
        }
    }catch (Exception e){
        // handle the exception
     }
    }
}
