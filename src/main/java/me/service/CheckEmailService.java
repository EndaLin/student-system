package me.service;

/**
 * @Author: wt
 * @Date: 2019/2/18 16:18
 */
public interface CheckEmailService {
    /**
     * 验证信息的合法性
     * @param account
     * @param email
     * @return
     */
    boolean check(String account, String email);
}
