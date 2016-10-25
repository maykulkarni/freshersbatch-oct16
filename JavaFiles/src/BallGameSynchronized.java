import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BallGameSynchronized extends Frame {

    static Thread red, green, blue;
    int y1 = 400, y2 = 400, y3 = 400;

    public BallGameSynchronized() {
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
        Frame mf = new BallGameSynchronized();
        mf.setSize(500, 500);
        mf.setVisible(true);
        Red r = new Red(mf);
        Green g = new Green(mf);
        Blue b = new Blue(mf);
        new Thread(r).start();
        new Thread(g).start();
        new Thread(b).start();
    }

    synchronized public void testMe() throws InterruptedException {
        this.wait();
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

                    if (((BallGameSynchronized) mf).y1 == 400) {
                        synchronized (mf) {
                            mf.notifyAll();
                        }
                        direction = true;
                    }
                    if (((BallGameSynchronized) mf).y1 == 20) {
                        synchronized (mf) {
                            mf.notifyAll();
                        }
                        direction = false;
                    }
                    if (direction)
                        ((BallGameSynchronized) mf).y1 -= 20;
                    else
                        ((BallGameSynchronized) mf).y1 += 20;
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
                    if (((BallGameSynchronized) mf).y2 == 400) {
                        synchronized (mf) {
                            if (!firsTime)
                                mf.wait();
                        }
                        firsTime = false;
                        direction = true;
                    }
                    if (((BallGameSynchronized) mf).y2 == 20) {
                        synchronized (mf) {
                            mf.wait();
                        }
                        direction = false;
                    }
                    if (direction)
                        ((BallGameSynchronized) mf).y2 -= 20;
                    else
                        ((BallGameSynchronized) mf).y2 += 20;
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

                    if (((BallGameSynchronized) mf).y3 == 400) {
                        synchronized (mf) {
                            if (!firstTime)
                                mf.wait();
                        }
                        firstTime = false;
                        direction = true;
                    }
                    if (((BallGameSynchronized) mf).y3 == 20) {
                        synchronized (mf) {
                            mf.wait();
                        }
                        direction = false;
                    }
                    if (direction)
                        ((BallGameSynchronized) mf).y3 -= 20;
                    else
                        ((BallGameSynchronized) mf).y3 += 20;
                    mf.repaint();
                    Thread.sleep(200);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
