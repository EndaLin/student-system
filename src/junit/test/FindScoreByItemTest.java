package junit.test;

import me.domain.ErrorMess;
import me.domain.Score;
import me.service.Impl.FindAllItemServiceImpl;
import me.service.Impl.FindScoreByItemServiceImpl;

import java.util.ArrayList;

public class FindScoreByItemTest {

    public static void main(String args[]) {
        try {
            ArrayList<Score> scores = FindScoreByItemServiceImpl.find(4185, 20111);

            assert scores != null;
            for (Score score : scores) {
                System.out.println(score.toString());
            }

        } catch (ErrorMess errorMess) {
            errorMess.printStackTrace();
        }
    }
}
