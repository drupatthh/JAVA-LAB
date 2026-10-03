import java.applet.Applet;
import java.awt.Graphics;

public class AppletLifeCycleDemo extends Applet {
    private String message = "Applet lifecycle";

    @Override
    public void init() {
        message = "init() initializes the applet";
        System.out.println("init()");
    }

    @Override
    public void start() {
        message = "start() starts or resumes the applet";
        System.out.println("start()");
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString(message, 20, 40);
        graphics.drawString("paint() draws the applet contents", 20, 65);
        System.out.println("paint()");
    }

    @Override
    public void stop() {
        System.out.println("stop() pauses the applet");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() releases applet resources");
    }
}
