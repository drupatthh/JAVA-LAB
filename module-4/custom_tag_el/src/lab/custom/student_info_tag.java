package lab.custom;

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class student_info_tag extends SimpleTagSupport {
    private String name;
    private String course;

    public student_info_tag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write(
            "<section><h2>Student Information</h2><p>Name: " + escape(name)
                + "</p><p>Course: " + escape(course) + "</p></section>"
        );
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("&", "&amp;").replace("<", "&lt;")
            .replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}
