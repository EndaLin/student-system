package me.service;

import java.util.ArrayList;

import me.domain.ErrorMess;
import me.domain.Score;

public interface IFindScoreByItemService {
	/**
	 * @description 根据学生ID以及学期号查询该生的成绩信息
	 * @param 学生id, 学期grade
	 * @return ArrayList<Score>
	 * @throws ErrorMess
	 */
	static ArrayList<Score> find(int sid, int grade) throws ErrorMess {
		return null;
	}
}
