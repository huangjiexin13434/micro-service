package com.hjx.springcloud.service;

import com.hjx.entities.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 插入
     *
     * @param
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据id查找
     *
     * @param
     * @return
     */
    Dept findById(Long deptId);

    /**
     * 查询全部
     *
     * @return
     */
    List<Dept> findAll();
}
