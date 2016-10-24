import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BallGame extends Frame {

    static Thread red, green, blue;
    int y1 = 400, y2 = 400, y3 = 400;

    public BallGame() {
        super("Ball game");
//			new Thread(this).start();
//			new Thread(this).start();
//			new Thread(this).start();
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
        Frame mf = new BallGame();
        mf.setSize(500, 500);
        mf.setVisible(true);
//		red = new Thread() {
//			@Override
//			public void run() {
//				((BallGame)mf).y1++;
//				mf.repaint();
//				try {
//					Thread.sleep(799);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		red.start();
        new Thread() {
            @Override
            public void run() {
                boolean direction = false;
                for (; ; ) {

                    if (((BallGame) mf).y1 == 400)
                        direction = true;
                    if (((BallGame) mf).y1 == 20)
                        direction = false;
                    if (direction)
                        ((BallGame) mf).y1 -= 20;
                    else
                        ((BallGame) mf).y1 += 20;
                    mf.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                boolean direction = false;
                for (; ; ) {


                    if (((BallGame) mf).y2 == 400)
                        direction = true;
                    if (((BallGame) mf).y2 == 20)
                        direction = false;
                    if (direction)
                        ((BallGame) mf).y2 -= 20;
                    else
                        ((BallGame) mf).y2 += 20;
                    mf.repaint();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                boolean direction = false;
                for (; ; ) {

                    if (((BallGame) mf).y3 == 400)
                        direction = true;
                    if (((BallGame) mf).y3 == 20)
                        direction = false;
                    if (direction)
                        ((BallGame) mf).y3 -= 20;
                    else
                        ((BallGame) mf).y3 += 20;
                    mf.repaint();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(100, y1, 50, 50);
        g.setColor(Color.GREEN);
        g.fillOval(200, y2, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(300, y3, 50, 50);
    }

//	@Override
//	public void run() {
//		if (Thread.currentThread().getName().equals("red")) {
//			this.y1++;
//			this.repaint();
//			try {
//				Thread.sleep(799);
//				this.repaint();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} else if (Thread.currentThread().getName().equals("blue")) {
//			this.y2++;
//			this.repaint();
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} else if (Thread.currentThread().getName().equals("blue")) {
//			this.y3++;
//			this.repaint();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
