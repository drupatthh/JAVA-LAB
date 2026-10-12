package simplemvc;

public class student_model {
    private String name;
    private String course;

    public student_model(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
