package mvccrud;

public class student_record {
    private int id;
    private String name;
    private String course;

    public student_record(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
