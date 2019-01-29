package me.service.Impl;

import me.dao.impl.LoginDaoImpl;
import me.domain.User;
import me.service.ILoginService;

/**
 * 登录模块
 * */
public class LoginServiceImpl implements ILoginService {
	public static void check(User user) {
		LoginDaoImpl.find(user);
	}
}
