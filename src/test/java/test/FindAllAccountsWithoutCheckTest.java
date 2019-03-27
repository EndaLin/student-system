package test;

import me.domain.User;
import me.service.Impl.FindAllAccountsWithoutCheckServiceImpl;

import java.util.ArrayList;

public class FindAllAccountsWithoutCheckTest {
    public static void main(String args[]) {
        ArrayList<User> userArrayList = FindAllAccountsWithoutCheckServiceImpl.find();

        for (User user : userArrayList) {
            System.out.println(user.toString());
        }

    }
}
