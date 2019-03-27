package test;

import me.domain.ErrorMess;
import me.domain.Student;
import me.service.Impl.FindStudentByIdServiceImpl;

public class FindStudentByIdTest {

    public static void main(String args[]) {

        try {
            Student student = FindStudentByIdServiceImpl.find(1111);
            System.out.println(student.toString());
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
