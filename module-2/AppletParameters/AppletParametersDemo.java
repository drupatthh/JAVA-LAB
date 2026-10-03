import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class AppletParametersDemo extends Applet {
    private String message;

    @Override
    public void init() {
        message = getParameter("message");
        if (message == null) {
            message = "Hello from an applet";
        }

        setBackground(parseColor(getParameter("background"), Color.WHITE));
        setForeground(parseColor(getParameter("foreground"), Color.BLACK));
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString(message, 20, 40);
    }

    private Color parseColor(String value, Color defaultColor) {
        if (value == null) {
            return defaultColor;
        }
        try {
            return Color.decode(value);
        } catch (NumberFormatException e) {
            return defaultColor;
        }
    }
}
