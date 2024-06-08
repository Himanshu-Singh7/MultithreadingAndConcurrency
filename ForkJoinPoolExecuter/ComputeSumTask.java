package ForkJoinPoolExecuter;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask<Integer> {
      int start ;
      int end ;
      ComputeSumTask(int start, int end){
        this.start = start;
        this.end = end;
      }
      @Override
     protected Integer compute() {

          if(end - start <= 4){
              int totalSum =0 ;
              for(int i = start ; i<= end ; i++){
                  totalSum += i;
              }
              return totalSum;
          }else {
              //split the task
              int mid =(start + end)/ 2;
              ComputeSumTask leftTask = new ComputeSumTask(start , mid);
              ComputeSumTask rightTask = new ComputeSumTask(mid+1 , end);

              // fork the subtask for parallel execution
              leftTask.fork();
              rightTask.fork();

              //combine the result of subtask
              Integer leftjoin = leftTask.join();
              Integer rightjoin = rightTask.join();

              return leftjoin + rightjoin;
          }
      }
}
