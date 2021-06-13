import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test_threadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                15,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(20));

        for(int i=0;i<10;i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("The thread " + Thread.currentThread().getName() + " is running");
                }
            });
        }

        threadPoolExecutor.shutdownNow();
    }
}

