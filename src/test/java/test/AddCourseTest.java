package test;

import me.domain.ErrorMess;
import me.service.Impl.AddCourseServiceImpl;

public class AddCourseTest {

    public static void main(String args[]) {

        try {
            AddCourseServiceImpl.add("高等数学");
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
