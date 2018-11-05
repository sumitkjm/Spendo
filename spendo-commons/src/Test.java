import java.util.concurrent.*;

/**
 * Created by skumar6 on 6/12/18.
 */
public class Test {

    public static void main(String [] args) throws  Exception {

        Runnable task = ()->{
            System.out.println("Thread print from Lamda Expression");

        };

        if("HelloTest".equals(null)) {
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(task);
        future.get();
        executorService.shutdown();
//        Executor executor = Executors.newCachedThreadPool();
//        executor.execute(task);
    }

}
