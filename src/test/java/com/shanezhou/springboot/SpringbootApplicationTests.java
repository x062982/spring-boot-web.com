package com.shanezhou.springboot;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanezhou.springboot.dao.EmployeeMPMapper;
import com.shanezhou.springboot.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

	@Resource
	private EmployeeMPMapper mapper;

	@Test
	void contextLoads() {
		//List<Employee> employees = mapper.selectList(null);
		//for (Employee e : employees) {
		//	System.out.println(e);
		//}

		//QueryWrapper<Employee> wrapper = new QueryWrapper<>();
		//wrapper.eq(true, "username", "admin")
		//		//.ge(true, "age", 0)
		//.gt("age", 0);
		////List<Employee> employees = mapper.selectList(wrapper);
		//List<Employee> employees = mapper.selectPage(
		//		new Page<Employee>(2, 3), null).getRecords();
		//for (Employee e : employees) {
		//	System.out.println(e);
		//}

		//Employee employee = new Employee("shane1");
		//employee.setVersion(1);
		//UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
		//Map map = new HashMap();
		//map.put("username", "shane");
		//map.put("age", 0);
		//wrapper.allEq(map);
		//int update = mapper.update(employee, wrapper);
		for (int i = 1; i < 100; i++) {
			mapper.insert(new Employee("user" + i));
		}
	}

}
