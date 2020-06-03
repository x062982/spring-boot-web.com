package com.shanezhou.springboot.service.impl;

import com.shanezhou.springboot.dao.EmployeeMapper;
import com.shanezhou.springboot.entity.Employee;
import com.shanezhou.springboot.service.IEmployeeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/05/30 18:41 下午
 */
@Service
public class EmployeeServiceImpl implements IEmployeeServie {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public boolean save(Employee employee) {
        return employeeMapper.save(employee);
    }

    @Override
    public boolean updById(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public boolean delDyId(int id) {
        return employeeMapper.delete(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeMapper.findById(id);
    }

    @Override
    public Employee getByName(String name) {
        return employeeMapper.findByName(name);
    }
}
