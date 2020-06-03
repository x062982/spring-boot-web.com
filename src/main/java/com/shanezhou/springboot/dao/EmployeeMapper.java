package com.shanezhou.springboot.dao;

import com.shanezhou.springboot.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通过数据库对用户表进行操作
 * @Author shaneZhou
 * @Time 2020/05/30 18:23 下午
 */
@Component
public interface EmployeeMapper {

    /**
     * 新增用户
     * @param employee  用户对象
     * @return
     */
    @Insert("insert into employee(id, userName, password, email, age, gender, birthday, dept_id) values " +
            "(seq_emp_id.nextval, #{userName}, #{password}, #{email}, #{age}, #{gender}, #{birthday}, #{deptId})")
    boolean save(Employee employee);

    /**
     * 更新用户
     * @param employee  用户对象
     * @return
     */
    @Update("update employee set userName = #{userName}, password = #{password}, email = #{email}," +
            " gender = #{gender}, age = #{age}, birthday = #{birthday}, dept_id = #{deptId} where id = #{id}")
    boolean update(Employee employee);

    /**
     * 根据用户编号删除用户
     * @param id    用户编号
     * @return
     */
    @Delete("delete from employee where id = #{id}")
    boolean delete(int id);

    /**
     * 查找所有对象
     * @return
     */
    @Select("select * from employee")
    List<Employee> findAll();

    /**
     * 根据id编号查找用户
     * @param id    用户编号
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee findById(int id);

    /**
     * 根据用户名查找对象
     * @param userName  用户名
     * @return
     */
    @Select("select * from employee where username = #{userName}")
    Employee findByName(String userName);


}
