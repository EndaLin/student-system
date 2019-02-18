package junit.test;

import me.domain.ErrorMess;
import me.domain.Student;
import me.service.Impl.AddStudentsByExcelServiceImpl;
import me.service.Impl.ReadExcelServiceImpl;

import java.util.List;

public class AddStudentsByExcelTest {

    public static void main(String args[]) {

        ReadExcelServiceImpl readExcelService = new ReadExcelServiceImpl();
        List<List<String>> list = readExcelService.read("src/junit/test/testFile/student.xls");

        for (List<String> cellList : list) {

            if (cellList.size() != 2) {
                System.out.println("数据格式错误,请核实检查!");
            }
            //读取该行每一列的相关信息
            String sname = cellList.get(0);
            int cid = (int) (Double.parseDouble(cellList.get(1)));
            Student student = new Student(sname, cid); //封装数据

            System.out.println(student.toString());
        }

        try {
            AddStudentsByExcelServiceImpl.add(list);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
