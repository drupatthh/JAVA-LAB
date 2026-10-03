import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InteractiveAppletDemo extends Applet implements MouseListener {
    private String message = "Move the mouse inside the applet and click";
    private int x;
    private int y;

    @Override
    public void init() {
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString(message, 20, 30);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        x = event.getX();
        y = event.getY();
        message = "Clicked at x=" + x + ", y=" + y;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    @Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {
    }
}
