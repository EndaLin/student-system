package me.service;

import me.domain.ErrorMess;

public interface IAddClassService {
	/**
	 * @author wt
	 * @description 该方法用于添加班级信息
	 *  @param 班级名称
	 * @exception 若插入失败,请返回错误信息(自定义异常),如重名或者其它错误
	 *
	 */
	static void add(String name, int grade) throws ErrorMess{
	}
}
