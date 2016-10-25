import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WaterTankSynchronized extends Frame {

    public static boolean lock = false;
    public int currLevel = 100;
    int inlet = 400, outlet = 400;
    int waterLevelY = 100;
    int waterLevelHeight = 300;

    public WaterTankSynchronized() {
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

    public static void main(String[] args) {
        Frame mf = new WaterTankSynchronized();
        mf.setSize(500, 500);
        mf.setVisible(true);
        new Thread(new Inlet(mf)).start();
        new Thread(new Outlet(mf)).start();
    }

    private void changeWaterLevel(int changeInPercent) {
        currLevel += changeInPercent;
        System.out.println("Change : " + changeInPercent + " currlevel : " + currLevel);
        float change = (changeInPercent * 300) / 100;
        System.out.println(change);
        this.waterLevelHeight += change;
        this.waterLevelY -= change;
        System.out.println("wlh : " + waterLevelHeight + " wly : " + waterLevelY);

    }

    public void paint(Graphics g) {
        // Outer tank
        g.drawRect(150, 100, 200, 300);
        g.setColor(Color.CYAN);
        // Inner water
        g.fillRect(150, waterLevelY, 200, waterLevelHeight);

        g.setColor(Color.black);
        g.drawString(currLevel + "%", 380, 200);
    }

    public static class Inlet extends Thread {
        Frame mf;

        Inlet(Frame frame) {
            this.mf = frame;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    if (!lock) {
                        if (((WaterTankSynchronized) mf).currLevel >= 80) {
                            lock = true;
                            synchronized (mf) {
                                System.out.println("Inlet : notifying other thread");
                                mf.notify();
                            }
                        }
                        ((WaterTankSynchronized) mf).changeWaterLevel(+10);
                        mf.repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        synchronized (mf) {
                            System.out.println("Inlet : can't get lock, waiting");
                            mf.wait();

                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("Err");
                }
            }
            //catch
        }
    }

    public static class Outlet extends Thread {
        Frame mf;

        Outlet(Frame frame) {
            this.mf = frame;
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    if (lock) {
                        if (((WaterTankSynchronized) mf).currLevel <= 0) {
                            lock = false;
                            synchronized (mf) {
                                System.out.println("Outlet : Notifying other threads");
                                mf.notifyAll();
                            }
                        }
                        ((WaterTankSynchronized) mf).changeWaterLevel(-10);
                        mf.repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        synchronized (mf) {
                            System.out.println("Outlet : Cant get lock, waiting");
                            mf.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("err");
                }
            }
        }
    }


}
