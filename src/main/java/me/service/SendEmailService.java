package me.service;

/**
 * @Author: wt
 * @Date: 2019/2/18 16:24
 */
public interface SendEmailService {
    /**
     * 发送邮件
     * @param account
     * @param email
     */
    void send(String account, String email);
}
