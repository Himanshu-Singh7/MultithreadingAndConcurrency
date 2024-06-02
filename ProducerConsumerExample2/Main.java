package ProducerConsumerExample2;

public class Main {
    public static void main(String[] args) {
        SharedResourse sharedResourse = new SharedResourse(3);

        Thread producertask = new Thread(new ProducerTask(sharedResourse));
        Thread consumertask = new Thread(new ConsumerTask(sharedResourse));

        producertask.start();

        consumertask.start();

       // Output

        /*Produced : 0
        Produced : 1
        Produced : 2
        Buffer is full,Producer is waiting for consumer
        Consumed : 0
        Consumed : 1
        Consumed : 2
        Buffer is empty .Consumer is waiting for Producer
        Produced : 3
        Produced : 4
        Produced : 5
        Consumed : 3
        Consumed : 4
        Consumed : 5*/

    }
}
