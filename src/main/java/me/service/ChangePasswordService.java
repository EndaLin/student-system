package me.service;

/**
 * @Author: wt
 * @Date: 2019/2/18 17:08
 */
public interface ChangePasswordService {
    /**
     * 密码修改
     * @param account
     * @param password
     */
    void change(String account, String password);
}
