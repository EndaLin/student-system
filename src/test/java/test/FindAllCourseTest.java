package test;

import me.domain.Course;
import me.service.Impl.FindAllCourseServiceImpl;

import java.util.ArrayList;

public class FindAllCourseTest {

    public static void main(String args[]) {
        ArrayList<Course> courseArrayList = FindAllCourseServiceImpl.find();

        for (Course course : courseArrayList) {
            System.out.println(course.toString());
        }
    }
}
