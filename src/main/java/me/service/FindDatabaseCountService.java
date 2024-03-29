package me.service;

import me.domain.Classes;
import me.domain.Message;
import me.domain.Student;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/2/19 10:21
 */
public interface FindDatabaseCountService {
    /**
     * 数据库分页信息
     * @param id
     * @return
     */
    Message check(String id);

    /**
     * 数据库分页信息
     * @param id
     * @return
     */
    Message checkForStudent(String id);

    /**
     * 根据当前页数查询数据
     * @param current
     * @return
     */
    List<Classes> findByCurrentPages(String id, String current);

    /**
     * 根据当前页数查询数据
     * @param current
     * @return
     */
    List<Student> findByCurrentPages2(String id, String current);
}
