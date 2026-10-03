interface Printable {
    void print();
}

class Student implements Printable {
    @Override
    public void print() {
        System.out.println("Student: Alex, Grade 10");
    }
}

class Teacher implements Printable {
    @Override
    public void print() {
        System.out.println("Teacher: Jordan, Mathematics");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Printable student = new Student();
        Printable teacher = new Teacher();

        student.print();
        teacher.print();
    }
}
