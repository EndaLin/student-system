package junit.test;

import me.domain.ErrorMess;
import me.service.Impl.ModifyCourseNameServiceImpl;

public class ModifyCourseNameTest {
    public static void main(String args[]) {

        try {
            ModifyCourseNameServiceImpl.modify(11111,"人工智能概论");
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
