package com.shanezhou.springboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanezhou.springboot.dao.EmployeeMPMapper;
import com.shanezhou.springboot.entity.Employee;
import com.shanezhou.springboot.service.IEmployeeMPService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @Author shaneZhou
 * @Time 2020/05/30 18:41 下午
 */
@Service
@DS("master")
@EnableTransactionManagement
public class EmployeeMPServiceImpl implements IEmployeeMPService {

    @Resource
    private EmployeeMPMapper mapper;

    @Override
    public int save(Employee employee) {
        return mapper.insert(employee);
    }

    @Override
    public int updById(Employee employee) {
        return mapper.updateById(employee);
    }

    @Override
    public int delDyId(int id) {
        return mapper.deleteById(id);
    }

    @Override
    public Page<Employee> getAll(int page, int pageSize) {
        return mapper.selectPage(new Page<Employee>(page, pageSize),
                null);
    }

    @Override
    public Employee getById(int id) {
        return mapper.selectById(id);
    }

    @Override
    public Employee getByName(String name) {
        return mapper.selectOne(new QueryWrapper<Employee>().eq("username", name));
    }
}
