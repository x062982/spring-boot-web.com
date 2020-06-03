package com.shanezhou.springboot.service;

import com.shanezhou.springboot.entity.Employee;

import java.util.List;

/**
 * 用户操作接口方法
 * @Author shaneZhou
 * @Time 2020/05/30 18:38 下午
 */
public interface IEmployeeServie {

    /**
     * 保存用户
     * @param employee  用户对象
     * @return
     */
    boolean save(Employee employee);

    /**
     * 根据id查找用户进行更新
     * @param employee  用户对象
     * @return
     */
    boolean updById(Employee employee);

    /**
     * 根据id编号删除用户
     * @param id    用户编号
     * @return
     */
    boolean delDyId(int id);

    /**
     * 查找所有用户
     * @return
     */
    List<Employee> getAll();

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
