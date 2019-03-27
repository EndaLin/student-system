package test;

import me.domain.ErrorMess;
import me.domain.Student;
import me.service.Impl.AddStudentServiceImpl;

public class AddStudentTest {
    public static void main(String args[]) {
        try {
            Student student = new Student("琉璃平",50);
            AddStudentServiceImpl.add(student);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }

        try {
            Student student = new Student("琉璃平",5000);
            AddStudentServiceImpl.add(student);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
