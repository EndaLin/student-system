package junit.test;

import me.domain.ErrorMess;
import me.service.Impl.ModifyScoresByExcelServiceImpl;
import me.service.Impl.ReadExcelServiceImpl;

import java.util.List;

public class ModifyScoreByExcelTest {

    public static void main(String args[]) {

        ReadExcelServiceImpl readExcelService = new ReadExcelServiceImpl();
        List<List<String>> list = readExcelService.read("src/junit/test/testFile/score.xls");

        for (List<String> cellList : list) {

            if (cellList.size() != 4) {
                System.out.println("数据格式错误,请核实检查!");
            }

            //改一改分数, 让分数随机
            cellList.set(2, String.valueOf((int) (Math.random() * 60) + 40));

            //读取该行每一列的相关信息
            int sid = (int) (Double.parseDouble(cellList.get(0)));
            int cid = (int) (Double.parseDouble(cellList.get(1)));
            int score = (int) (Double.parseDouble(cellList.get(2)));
            int grade = (int) (Double.parseDouble(cellList.get(3)));

            System.out.println(sid + " " + cid + " " + score + " " + grade);
        }

        try {
            ModifyScoresByExcelServiceImpl.modify(list);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
