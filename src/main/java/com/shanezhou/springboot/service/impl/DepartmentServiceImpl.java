package com.shanezhou.springboot.service.impl;

import com.shanezhou.springboot.dao.DepartmentMapper;
import com.shanezhou.springboot.entity.Department;
import com.shanezhou.springboot.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ShaneZhou
 * @Time 2020/06/01 16:52:08
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getById(int id) {
        return departmentMapper.findById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentMapper.findAll();
    }
}
