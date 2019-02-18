package me.service;

import me.domain.ErrorMess;
import me.domain.User;

public interface IRegisterService {
	/**
	 * @description 用于管理员账号注册,注意:此处的注册还需要其余管理员的审核通过方能授权登陆
	 * @param user,0-管理员,1-学生
	 * @exception ErrorMess
	 */
	static void add(User user) throws ErrorMess {

	}
}
