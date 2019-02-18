package me.service.Impl;

import me.service.SendEmailService;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * @Author: wt
 * @Date: 2019/2/18 16:27
 */
public class SendEmailServiceImpl implements SendEmailService {

    @Override
    public void send(String account, String address) {
        try {
            //编辑发送内容
            String mess="http://localhost:8080/changePassword.html?account=" + account;

            //创建一个新对象
            Email email = new SimpleEmail();

            //设置邮箱服务器的地址
            email.setHostName("smtp.139.com");

            //设置服务器端口
            email.setSmtpPort(465);

            //设置服务器的登陆账号和密码
            email.setAuthenticator(new DefaultAuthenticator("13727782882@139.com", "wt123456"));

            //是否开启SSL验证
            email.setSSLOnConnect(true);

            //写入发送用户的邮箱
            email.setFrom("13727782882@139.com");

            //写入发送主题
            email.setSubject("密码修改");

            //写入发送内容
            email.setMsg(mess);

            //添加被发送用户
            email.addTo(address);

            //发送
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
