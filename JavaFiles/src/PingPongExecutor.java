import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kulkarni_my on 10/24/2016.
 */
public class PingPongExecutor extends Thread {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            for (; ; ) {
                System.out.println("Ping");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(() -> {
            for (; ; ) {
                System.out.println("\tPong");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}