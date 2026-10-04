import college.Student;
import college.department.ITStudent;

class Packagedemo {
  public static void main(String args[]){
    Student s1 = new Student();
    ITStudent s2 = new ITStudent();

    s1.displayDetails();
    s2.displayInformation();
  }
  
}
