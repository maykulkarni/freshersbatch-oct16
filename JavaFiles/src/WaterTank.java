import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WaterTank extends Frame {

    public int currLevel = 100;
    int inlet = 400, outlet = 400;
    int waterLevelY = 100;
    int waterLevelHeight = 300;

    public WaterTank() {
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
        Frame mf = new WaterTank();
        mf.setSize(500, 500);
        mf.setVisible(true);

        Thread inlet = new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    ((WaterTank) mf).changeWaterLevel(+10);
                    mf.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread outlet = new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    ((WaterTank) mf).changeWaterLevel(-10);
                    mf.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("From main : Current level : " + ((WaterTank) mf).currLevel);
                    if (((WaterTank) mf).currLevel > 80) {
                        if (!outlet.isAlive()) {
                            outlet.start();
                            if (inlet.isAlive()) inlet.suspend();
                        } else {
                            inlet.suspend();
                            outlet.resume();
                        }

                    } else if (((WaterTank) mf).currLevel <= 0) {
                        if (!inlet.isAlive()) {
                            inlet.start();
                            if (outlet.isAlive()) outlet.suspend();
                        } else {
                            inlet.resume();
                            outlet.suspend();
                        }
                    }
                }
            }
        }.start();

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
}
