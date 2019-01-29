package junit.test;

import me.domain.ErrorMess;
import me.service.Impl.DeleteStudentByIdServiceImpl;

public class DeleteStudentByIdTest {
    public static void main(String args[]) {

        try {
            DeleteStudentByIdServiceImpl.delete(1100);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
