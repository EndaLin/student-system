package me.service;

import java.util.ArrayList;

import me.domain.ErrorMess;

public interface IFindAllItemsService {
	/**
	 * @description 根据学生ID获取可选学期的信息，为查询成绩做准备
	 * @param sid
	 * @return ArrayList<Integer> 可选学期集合
	 * @throws ErrorMess
	 */
	static ArrayList<Integer> find(int sid) throws ErrorMess {
		return null;
	}
}
