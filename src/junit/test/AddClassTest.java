package junit.test;

import me.domain.ErrorMess;
import me.service.Impl.AddClassServiceImpl;

public class AddClassTest {

    public static void main(String args[]) {

        try {
            AddClassServiceImpl.add("软件工程卓越1班", 2010);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
