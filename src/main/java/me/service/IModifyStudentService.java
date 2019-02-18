package me.service;

import me.domain.ErrorMess;

public interface IModifyStudentService {
	/**
	 * @description 根据学生ID修改学生信息
	 * @param 学生编号sid, 学生姓名name, 班级编号cid
	 * @throws ErrorMess
	 */
	static void modify(int sid, String name, int cid) throws ErrorMess {

	}
}
