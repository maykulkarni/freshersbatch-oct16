import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BallGameSynchronizedUsingReentrantLock extends Frame {
    static ReentrantLock lock;
    static Condition cond;
    static Thread red, green, blue;
    static boolean available = false;
    int y1 = 400, y2 = 400, y3 = 400;

    public BallGameSynchronizedUsingReentrantLock() {
        super("Ball game");
        setBackground(Color.WHITE);
        setSize(500, 500);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {
        lock = new ReentrantLock();
        cond = lock.newCondition();
        Frame mf = new BallGameSynchronizedUsingReentrantLock();
        mf.setSize(500, 500);
        mf.setVisible(true);
        Red r = new Red(mf);
        Green g = new Green(mf);
        Blue b = new Blue(mf);
        new Thread(r).start();
        new Thread(g).start();
        new Thread(b).start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(100, y1, 50, 50);
        g.setColor(Color.GREEN);
        g.fillOval(200, y2, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(300, y3, 50, 50);
    }

    public static class Red extends Thread {
        Frame mf;

        Red(Frame mf) {
            this.mf = mf;
        }

        @Override
        public void run() {

            try {
                boolean direction = false;
                for (; ; ) {

                    if (((BallGameSynchronizedUsingReentrantLock) mf).y1 == 400) {
                        lock.lock();
                        cond.signalAll();
                        lock.unlock();
                        direction = true;
                    }
                    if (((BallGameSynchronizedUsingReentrantLock) mf).y1 == 20) {
                        lock.lock();
                        cond.signalAll();
                        lock.unlock();
                        direction = false;
                    }
                    if (direction)
                        ((BallGameSynchronizedUsingReentrantLock) mf).y1 -= 20;
                    else
                        ((BallGameSynchronizedUsingReentrantLock) mf).y1 += 20;
                    mf.repaint();
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                System.out.println("Error");
            }

        }
    }

    public static class Green extends Thread {
        Frame mf;

        Green(Frame mf) {
            this.mf = mf;
        }

        @Override
        public void run() {


            try {
                boolean direction = false;
                boolean firsTime = true;
                for (; ; ) {
                    if (((BallGameSynchronizedUsingReentrantLock) mf).y2 == 400) {
                        if (!firsTime) {
                            lock.lock();
                            cond.await();
                            lock.unlock();
                        }
                        firsTime = false;
                        direction = true;
                    }
                    if (((BallGameSynchronizedUsingReentrantLock) mf).y2 == 20) {
                        lock.lock();
                        cond.await();
                        lock.unlock();
                        direction = false;
                    }
                    if (direction)
                        ((BallGameSynchronizedUsingReentrantLock) mf).y2 -= 20;
                    else
                        ((BallGameSynchronizedUsingReentrantLock) mf).y2 += 20;
                    mf.repaint();

                    Thread.sleep(300);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class Blue extends Thread {
        Frame mf;

        Blue(Frame mf) {
            this.mf = mf;
        }

        @Override
        public void run() {

            boolean direction = false;
            boolean firstTime = true;
            try {
                for (; ; ) {

                    if (((BallGameSynchronizedUsingReentrantLock) mf).y3 == 400) {
                        if (!firstTime) {
                            lock.lock();
                            cond.await();
                            lock.unlock();
                        }
                        firstTime = false;
                        direction = true;
                    }
                    if (((BallGameSynchronizedUsingReentrantLock) mf).y3 == 20) {
                        lock.lock();
                        cond.await();
                        lock.unlock();
                        direction = false;
                    }
                    if (direction)
                        ((BallGameSynchronizedUsingReentrantLock) mf).y3 -= 20;
                    else
                        ((BallGameSynchronizedUsingReentrantLock) mf).y3 += 20;
                    mf.repaint();
                    Thread.sleep(200);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
