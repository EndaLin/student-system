package me.service;

import java.util.ArrayList;

import me.domain.Course;
import me.domain.ErrorMess;

public interface IFindCourseBySidService {
	/**
	 * @description 根据学生ID查询该生的课程信息，为后续的查询成绩做准备
	 * @param 学生IDid
	 * @return ArrayList<Course>可选的课程信息集合
	 */
	static ArrayList<Course> find(int id) throws ErrorMess{
		return null;
	}
}
