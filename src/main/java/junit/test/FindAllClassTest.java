package junit.test;

import me.domain.Classes;
import me.service.Impl.FindAllClassServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;

public class FindAllClassTest {

    public static void main(String args[]) {
        ArrayList<Classes> classesArrayList = FindAllClassServiceImpl.find();

        for (Classes classes : classesArrayList) {
            System.out.println(classes.toString());
        }

    }
}
