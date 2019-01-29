package junit.test;

import me.domain.Course;
import me.domain.ErrorMess;
import me.service.Impl.FindCourseBySidServiceImpl;
import java.util.ArrayList;

public class FindCourseBySidTest {
    public static void main(String args[]) {

        try {
            ArrayList<Course> coursesArrayList = FindCourseBySidServiceImpl.find(4185);

            for (Course course : coursesArrayList) {
                System.out.println(course.toString());
            }
        } catch (ErrorMess errorMess) {
            errorMess.printStackTrace();
        }



    }
}
