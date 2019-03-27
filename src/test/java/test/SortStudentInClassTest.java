package test;

import me.domain.ErrorMess;
import me.domain.Score;
import me.service.Impl.SortStudentInClassServiceImpl;

import java.util.ArrayList;

public class SortStudentInClassTest {

    public static void main(String args[]) {
        try {
            ArrayList<Score> scores = SortStudentInClassServiceImpl.sort(4186, 20111);

            assert scores != null;
            for (Score score : scores) {
                System.out.println(score.toString());
            }

        } catch (ErrorMess errorMess) {
            errorMess.printStackTrace();
        }
    }
}
