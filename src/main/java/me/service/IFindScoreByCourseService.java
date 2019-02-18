package me.service;

import java.util.ArrayList;

import me.domain.ErrorMess;
import me.domain.Score;

public interface IFindScoreByCourseService {
	/**
	 * @description 根据学生ID以及学期号查询该生的成绩信息
	 * @param 学生id, 课程ID获取学生信息
	 * @return
	 * @throws ErrorMess
	 */
	static ArrayList<Score> find(int sid, int courseid) throws ErrorMess {
		return null;
	}
}
