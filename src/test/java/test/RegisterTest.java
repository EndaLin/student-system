package test;

import me.domain.ErrorMess;
import me.domain.User;
import me.service.Impl.RegisterServiceImpl;

public class RegisterTest {
    public static void main(String args[]) {
        try {
            User user = new User("four", "159258", 1);
            RegisterServiceImpl.add(user);
        } catch (ErrorMess errorMess) {
            System.out.println(errorMess.getMessage());
        }
    }
}
