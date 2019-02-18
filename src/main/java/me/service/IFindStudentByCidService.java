package me.service;

import java.util.ArrayList;

import me.domain.Student;

public interface IFindStudentByCidService {
	/**
	 * @param 班级ID
	 * @return ArrayList<Student>,若没有找到,则返回null;
	 */
	static ArrayList<Student> find(int id) {
		return null;
	}
}
