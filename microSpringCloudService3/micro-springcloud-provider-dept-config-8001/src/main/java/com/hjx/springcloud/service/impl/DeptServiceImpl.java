package com.hjx.springcloud.service.impl;

import com.hjx.entities.Dept;
import com.hjx.springcloud.dao.DeptDao;
import com.hjx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {

        return deptDao.addDept(dept);
    }

    @Override
    public Dept findById(Long deptId) {
        return deptDao.findById(deptId);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
