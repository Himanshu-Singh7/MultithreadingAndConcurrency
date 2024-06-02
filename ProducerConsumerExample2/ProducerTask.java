package ProducerConsumerExample2;

public class ProducerTask implements Runnable{

    SharedResourse sharedResourse;

    ProducerTask(SharedResourse resourse){
        this.sharedResourse = resourse;
    }
    @Override
    public void run() {

        try {
            for(int i = 0 ; i < 6 ; i++){
            sharedResourse.producer(i);
            }
        }catch (Exception e){

        }
    }
}
