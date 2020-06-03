package com.shanezhou.springboot.controller;

import com.shanezhou.springboot.entity.Department;
import com.shanezhou.springboot.entity.Employee;
import com.shanezhou.springboot.service.IDepartmentService;
import com.shanezhou.springboot.service.IEmployeeServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * 用户操作控制器
 * @Author shaneZhou
 * @Time 2020/05/30 18:43 下午
 */
@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeServie employeeServie;

    @Autowired
    private IDepartmentService departmentService;

    /**
     * 用户登录
     * @param userName  用户名
     * @param password  密码
     * @param map
     * @param session
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session,
                        HttpServletRequest request, HttpServletResponse response) {
        Employee employee = employeeServie.getByName(userName);
        // 记住我
        String remember = request.getParameter("remember");
        if (employee == null) {
            map.put("msg", "用户名【" + userName + "】不存在！");
            return "index";
        } else if (!employee.getPassword().equals(password)){
            map.put("msg", "密码错误！");
            return "index";
        } else {
            if ("1".equals(remember)) {
                response.addCookie(new Cookie(userName,  password));
                response.addCookie(new Cookie("remember",  remember));
            }
            session.setAttribute("username", userName);
            return "redirect:/main.html";
        }
    }

    /**
     * 展示所有成员
     * @param map
     * @return
     */
    @GetMapping("/emps")
    public String getEmpAll(Map<String, Object> map) {
        List<Employee> employeeList = employeeServie.getAll();
        for (Employee emp : employeeList) {
            int deptId = emp.getDeptId();
            if (deptId != 0) {
                Department dept = departmentService.getById(deptId);
                emp.setDepartment(dept);
            }
        }
        map.put("emps", employeeList);
        return "/list";
    }

    /**
     * 跳转到添加页面
     * @param map
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Map<String, Object> map) {
        List<Department> departmentList = departmentService.getAll();
        map.put("departments", departmentList);
        return "addPage";
    }

    /**
     *  添加用户
     * @param employee  用户对象
     * @param map
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee, Map<String, Object> map) {
        Employee emp = employeeServie.getByName(employee.getUserName());
        if (emp == null) {
            employeeServie.save(employee);
            return "redirect:/emps";
        } else {
            List<Department> departmentList = departmentService.getAll();
            map.put("departments", departmentList);
            map.put("msg", "【"+ employee.getUserName() +"】已经存在！");
            return "addPage";
        }
    }

    /**
     * 跳转到修改页面
     * @param id    用户id
     * @param map
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") int id, Map<String, Object> map) {
        Employee employee = employeeServie.getById(id);
        map.put("emp", employee);
        List<Department> departmentList = departmentService.getAll();
        map.put("departments", departmentList);
        return "addPage";
    }

    /**
     * 更新用户
     * @param employee  用户对象
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        System.out.println(employee);
        boolean upd = employeeServie.updById(employee);
        return "redirect:/emps";
    }

    /**
     * 根据id删除用户
     * @param id    用户编号
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeServie.delDyId(id);
        return "redirect:/emps";
    }

    /**
     * 用户退出
     * @param request
     * @param map
     * @return
     */
    @GetMapping("/signout")
    public String signOut(HttpServletRequest request, Map<String, Object> map) {
        map.put("msg", "用户正常退出！");
        request.getSession().removeAttribute("username");
        return "index";
    }

}

