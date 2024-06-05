package LockFreeConsurency;

// Make thread safe Atomic Variable
// Solution Using Lock  Like Synchronized. Without Synchronized may be data losses for two or more Thread
public class SharedResource {

    int counter = 0;

    // Using Lock  Like Synchronized.Without Synchronized may be data losses for two or more Thread
    public synchronized void increment(){
       counter++;
    }

    public int get(){

        return counter;

    }
}
