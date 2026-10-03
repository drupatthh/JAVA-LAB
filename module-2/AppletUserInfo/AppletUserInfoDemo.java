import java.applet.Applet;
import java.awt.Graphics;

public class AppletUserInfoDemo extends Applet {
    private String name;
    private String registerNumber;
    private String course;
    private String semester;

    @Override
    public void init() {
        name = getParameter("name");
        registerNumber = getParameter("registerNumber");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawString("Student: " + value(name), 20, 30);
        graphics.drawString("Register number: " + value(registerNumber), 20, 55);
        graphics.drawString("Course: " + value(course), 20, 80);
        graphics.drawString("Semester: " + value(semester), 20, 105);
    }

    private String value(String parameter) {
        return parameter == null ? "Not provided" : parameter;
    }
}
