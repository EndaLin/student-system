package me.service;

import me.domain.ErrorMess;
import me.domain.Student;

/**
 * @author wt
 * @description 该方法用于添加学生信息
 * @param student类 注意:此处传入的有效参数只有sname和cid,其余两个均为无效默认值
 * @exception 若发生错误,请返回错误信息
 * 
 *
 */
public interface IAddStudentService {

	static void add(Student stu) throws ErrorMess {

	}
}
