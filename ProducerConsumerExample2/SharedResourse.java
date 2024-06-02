package ProducerConsumerExample2;

import java.util.LinkedList;
import java.util.Queue;

/*Two threads, a producer and a consumer, share a common, fixed-size buffer as a queue.
The producer's job is to generate data and put it into the buffer, while the consumer's job is to consume the data from the buffer.
The problem is to make sure that the producer won't produce data if the buffer is full, and the consumer won't consume data if the buffer is empty.*/
public class SharedResourse {
    private Queue<Integer> sharedResource;
    private int bufferSize;

    public SharedResourse(int bufferSize) {
        sharedResource = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void producer(int item){
       // If buffer is full , wait for consumer to consume the item .
        while (sharedResource.size() == bufferSize){
            try {
                System.out.println("Buffer is full,Producer is waiting for consumer");
                wait();

            }catch (Exception e){

            }
        }
        sharedResource.add(item);
        System.out.println("Produced : " + item);
        // Notify the consumer that there are item to consume now.
        notify();

    }

    public synchronized int consumer(){
        while (sharedResource.isEmpty()){
            try {
                System.out.println("Buffer is empty .Consumer is waiting for Producer");
                wait();
            }catch (Exception e){
              // handle the exception
            }
        }
        int iteam = sharedResource.poll();
        System.out.println("Consumed : " + iteam);
        //Notify the producer that there is space in the buffer now .
        notify();
        return iteam;
    }

}
