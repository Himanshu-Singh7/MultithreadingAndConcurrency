package LockFreeConsurency;

import java.util.concurrent.atomic.AtomicInteger;

// 2 : Using Lock free operation like AtomicInteger ->> AtomicInteger are internally uses a Compare-and-Swap technique.
/*
Atomic useCases is -->
        Read,
        Modify and
        update            */
public class SharedResource1 {

    AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int get(){
        return counter.get();
    }

}



