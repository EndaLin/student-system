package me.domain;


public class User {
    private String account; // 用户账号, 注意:此处不可以改为Int类型,因为管理员账号可为String
    private String password; // 用户密码
    private int type; // 用户类型


    public User(String account, String password, int type) {
        super();
        this.account = account;
        this.password = password;
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ("account = " + account + ", passworld = " + password + ", type = " + type);
    }
}
