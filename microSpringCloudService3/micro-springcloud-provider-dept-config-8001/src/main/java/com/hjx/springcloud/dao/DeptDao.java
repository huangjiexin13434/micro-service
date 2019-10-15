package com.hjx.springcloud.dao;

import com.hjx.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    /**
     * 插入
     *
     * @param Dept
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据id查找
     *
     * @param deptNo
     * @return
     */
    Dept findById(Long deptNo);

    /**
     * 查询全部
     *
     * @return
     */
    List<Dept> findAll();
}

