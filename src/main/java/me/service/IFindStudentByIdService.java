package me.service;

import me.domain.Student;

public interface IFindStudentByIdService {
	/**
	 * @param 学生ID
	 * @return Student类,若没找到,返回null
	 */
	static Student find(int id) {
		return null;
	}
}
