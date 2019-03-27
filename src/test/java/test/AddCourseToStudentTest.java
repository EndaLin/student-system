package test;

import me.domain.ErrorMess;
import me.service.Impl.AddCourseToStudentServiceImpl;
import me.service.Impl.ReadExcelServiceImpl;

import java.util.List;

public class AddCourseToStudentTest {

    public static void main(String args[]) {

        ReadExcelServiceImpl readExcelService = new ReadExcelServiceImpl();
        List<List<String>> list = readExcelService.read("src/junit/test/testFile/score.xls");

        for (List<String> cellList : list) {

            if (cellList.size() != 4) {
                System.out.println("数据格式错误,请核实检查!");//为全班同学加一个课程
            }

            cellList.set(3, String.valueOf(20111));

            //读取该行每一列的相关信息
            int sid = (int) (Double.parseDouble(cellList.get(0)));
            int cid = (int) (Double.parseDouble(cellList.get(1)));
            int score = (int) (Double.parseDouble(cellList.get(2)));
            int grade = (int) (Double.parseDouble(cellList.get(3)));

            System.out.println(sid + " " + cid + " " + score + " " + grade);
        }

        try {
            AddCourseToStudentServiceImpl.add(list);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
