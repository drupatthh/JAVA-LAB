import java.applet.Applet;
import java.awt.Graphics;

public class MovingCircleAppletDemo extends Applet implements Runnable {
    private volatile boolean running;
    private Thread animationThread;
    private int x;

    @Override
    public void init() {
        x = 0;
    }

    @Override
    public synchronized void start() {
        if (animationThread == null || !animationThread.isAlive()) {
            running = true;
            animationThread = new Thread(this, "CircleAnimation");
            animationThread.start();
        }
    }

    @Override
    public void run() {
        while (running) {
            x = (x + 5) % Math.max(getWidth(), 1);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.fillOval(x, getHeight() / 2 - 15, 30, 30);
    }

    @Override
    public synchronized void stop() {
        running = false;
        if (animationThread != null) {
            animationThread.interrupt();
            animationThread = null;
        }
    }

    @Override
    public void destroy() {
        stop();
    }
}
