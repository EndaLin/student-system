package me.service;

import me.domain.Classes;

import java.util.List;

/**
 * @Author: wt
 * @Date: 2019/2/21 14:49
 */
public interface FindClassSizeService {
    /**
     * 查找各个班级的人数情况
     * @return
     */
    List<Classes> check();
}
