package com.shanezhou.springboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.shanezhou.springboot.dao.EmployeeMapper;
import com.shanezhou.springboot.entity.Employee;
import com.shanezhou.springboot.service.IEmployeeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author shaneZhou
 * @Time 2020/05/30 18:41 下午
 */
@Service
@DS("master")
@EnableTransactionManagement
public class EmployeeServiceImpl implements IEmployeeServie {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public int save(Employee employee) {
        return employeeMapper.save(employee);
    }

    @Override
    public int updById(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public int delDyId(int id) {
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
