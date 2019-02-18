package junit.test;


import me.domain.ErrorMess;
import me.service.Impl.DeleteCourseByIdServiceImpl;

public class DeleteCourseByIdTest {

    public static void main(String args[]) {

        try {
            DeleteCourseByIdServiceImpl.delete(114);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
