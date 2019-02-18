package junit.test;

import me.domain.Course;
import me.domain.ErrorMess;
import me.domain.Student;
import me.service.Impl.AddCourseByExcelServiceImpl;
import me.service.Impl.AddStudentsByExcelServiceImpl;
import me.service.Impl.ReadExcelServiceImpl;

import java.util.List;

public class AddCourseByExcelTest {

    public static void main(String args[]) {

        ReadExcelServiceImpl readExcelService = new ReadExcelServiceImpl();
        List<List<String>> list = readExcelService.read("src/junit/test/testFile/course.xls");

        for (List<String> cellList : list) {

            if (cellList.size() != 1) {
                System.out.println("数据格式错误,请核实检查!");
            }
            //读取该行每一列的相关信息
            String cname = cellList.get(0);
            Course course = new Course(-1, cname); //封装数据

            System.out.println(course.toString());
        }

        try {
            AddCourseByExcelServiceImpl.add(list);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
