package test;

import me.domain.ErrorMess;
import me.domain.Score;
import me.service.Impl.FindScoreByCourseServiceImpl;

import java.util.ArrayList;

public class FindScoreByCourseTest {

    public static void main(String args[]) {
        try {
            ArrayList<Score> scores = FindScoreByCourseServiceImpl.find(4186, 48);

            assert scores != null;
            for (Score score : scores) {
                System.out.println(score.toString());
            }

        } catch (ErrorMess errorMess) {
            errorMess.printStackTrace();
        }
    }
}
