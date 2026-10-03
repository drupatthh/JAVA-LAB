import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseKeyboardEventsDemo extends Frame {
    private final Label status = new Label("Move or click the mouse; press a key");

    public MouseKeyboardEventsDemo() {
        super("Mouse and Keyboard Events");
        add(status);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent event) {
                status.setText("Mouse position: " + event.getX() + ", " + event.getY());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                status.setText("Mouse clicked at: " + event.getX() + ", " + event.getY());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                status.setText("Key pressed: " + KeyEvent.getKeyText(event.getKeyCode()));
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
            }
        });
        setSize(420, 200);
        setFocusable(true);
        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args) {
        new MouseKeyboardEventsDemo();
    }
}
