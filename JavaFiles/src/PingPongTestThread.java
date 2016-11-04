/**
 * Created by kulkarni_my on 10/24/2016.
 */
public class PingPongTestThread extends Thread {

    PingPongTestThread() {
        Thread ping = new Thread(this, "Ping");
        Thread pong = new Thread(this, "Pong");
        Thread tong = new Thread(this, "Tong");
        tong.setDaemon(true);
        ping.start();
        pong.start();
        tong.start();
    }

    public static void main(String[] args) {
        new PingPongTest();
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Ping")) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Ping");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (Thread.currentThread().getName().equals("Pong")) {
            for (int i = 0; i < 10; i++) {
                System.out.println("\tPing");
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (; ; ) {
                System.out.println("\t\tTong");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
