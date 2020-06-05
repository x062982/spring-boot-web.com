package com.shanezhou.springboot.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanezhou.springboot.entity.Employee;

/**
 * @Author ShaneZhou
 * @Time 2020/06/04 09:53:46
 */
@DS("master")
public interface EmployeeMPMapper extends BaseMapper<Employee> {

}
