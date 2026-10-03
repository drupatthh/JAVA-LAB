interface Sports {
    void displaySportsInfo();
}

interface Academics {
    void displayAcademicInfo();
}

public class MultipleInterfacesDemo {
    static class Student implements Sports, Academics {
        @Override
        public void displaySportsInfo() {
            System.out.println("Sport: Basketball");
        }

        @Override
        public void displayAcademicInfo() {
            System.out.println("Grade: A");
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.displayAcademicInfo();
        student.displaySportsInfo();
    }
}
