package me.service;

import java.util.ArrayList;

import me.domain.ErrorMess;
import me.domain.Score;

public interface ISortStudentInClassService {
	/**
	 * @description 根据学号，根据总成绩对该班级所有学生进行排序
	 * @param sid学生学号
	 * @param grade  学期号
	 * @return  排序后的结果(grade保存总成绩，成绩由高到底)
	 * @throws ErrorMess
	 */
	static ArrayList<Score> sort(int sid, int grade) throws ErrorMess {
		return null;
	}
}
