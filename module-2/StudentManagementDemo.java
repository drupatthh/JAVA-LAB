public class StudentManagementDemo {
    static class Student {
        private String name;
        private int rollNo;
        private double mark;

        Student() {
            this("Unknown", 0, 0);
        }

        Student(String name, int rollNo, double mark) {
            this.name = name;
            this.rollNo = rollNo;
            this.mark = mark;
        }

        void display() {
            System.out.println("Name: " + name + ", Roll number: " + rollNo + ", Mark: " + mark);
        }

        String calculateGrade(int marks) {
            return calculateGrade((double) marks);
        }

        String calculateGrade(double marks) {
            if (marks >= 90) {
                return "A";
            }
            if (marks >= 75) {
                return "B";
            }
            if (marks >= 60) {
                return "C";
            }
            if (marks >= 40) {
                return "D";
            }
            return "F";
        }
    }

    public static void main(String[] args) {
        Student first = new Student();
        Student second = new Student("Riley", 12, 88.5);
        Student third = new Student("Casey", 13, 72);

        first.display();
        second.display();
        third.display();
        System.out.println("Second student grade: " + second.calculateGrade(second.mark));
        System.out.println("Third student grade: " + third.calculateGrade(72));

        first = null;
        third = null;
        System.out.println("Some student objects are eligible for garbage collection.");
        System.gc();
        second.display();
    }
}
