package junit.test;

import me.domain.Classes;
import me.domain.Student;
import me.service.Impl.FindAllClassServiceImpl;
import me.service.Impl.FindStudentByCidServiceImpl;

import java.util.ArrayList;

public class FindStudentByCidTest {

    public static void main(String args[]) {
        ArrayList<Student> studentArrayList = FindStudentByCidServiceImpl.find(16);

        for (Student student : studentArrayList) {
            System.out.println(student.toString());
        }

    }
}
