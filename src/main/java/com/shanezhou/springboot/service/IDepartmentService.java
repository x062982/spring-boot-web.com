package com.shanezhou.springboot.service;

import com.shanezhou.springboot.entity.Department;

import java.util.List;

/**
 * 部门操作接口方法
 * @Author ShaneZhou
 * @Time 2020/06/01 16:51:18
 */
public interface IDepartmentService {

    /**
     * 根据部门编号查找部门
     * @param id    部门编号
     * @return
     */
    Department getById(int id);

    /**
     * 查找所有部门
     * @return
     */
    List<Department> getAll();
}
