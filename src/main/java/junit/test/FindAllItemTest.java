package junit.test;

import me.domain.ErrorMess;
import me.service.Impl.FindAllItemServiceImpl;
import java.util.ArrayList;

public class FindAllItemTest {
    public static void main(String args[]) {
        try {
            ArrayList<Integer> integerArrayList = FindAllItemServiceImpl.find(4185);

            for (Integer integer : integerArrayList) {
                System.out.println(integer);
            }

        } catch (ErrorMess errorMess) {
            errorMess.printStackTrace();
        }
    }
}
