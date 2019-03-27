package test;

import me.domain.Classes;
import me.service.Impl.FindAllClassServiceImpl;

import java.util.ArrayList;

public class FindAllClassTest {

    public static void main(String args[]) {
        ArrayList<Classes> classesArrayList = FindAllClassServiceImpl.find();

        for (Classes classes : classesArrayList) {
            System.out.println(classes.toString());
        }

    }
}
