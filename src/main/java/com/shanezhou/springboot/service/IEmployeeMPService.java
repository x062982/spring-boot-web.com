package com.shanezhou.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanezhou.springboot.entity.Employee;

/**
 * @Author ShaneZhou
 * @Time 2020/06/04 15:47:49
 */
public interface IEmployeeMPService {


    /**
     * 保存用户
     * @param employee  用户对象
     * @return
     */
    int save(Employee employee);

    /**
     * 根据id查找用户进行更新
     * @param employee  用户对象
     * @return
     */
    int updById(Employee employee);

    /**
     * 根据id编号删除用户
     * @param id    用户编号
     * @return
     */
    int delDyId(int id);

    /**
     * 查找所有用户
     * @return
     */
    Page<Employee> getAll(int page, int pageSize);

    /**
     * 根据id编号查找用户
     * @param id    用户编号
     * @return
     */
    Employee getById(int id);

    /**
     * 根据用户名查找用户
     * @param name  用户名
     * @return
     */
    Employee getByName(String name);

}
