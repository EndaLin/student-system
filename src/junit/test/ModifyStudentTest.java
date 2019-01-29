package junit.test;

import me.domain.ErrorMess;
import me.service.Impl.ModifyStudentServiceImpl;

public class ModifyStudentTest {
    public static void main(String args[]) {

        try {
            ModifyStudentServiceImpl.modify(555, "凛凛林", 55);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
