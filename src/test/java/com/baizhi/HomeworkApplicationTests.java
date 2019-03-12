package com.baizhi;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
		/*List<User> list = userDao.selectAll();
		for (User user : list) {
			System.out.println(user);
		}*/
		List<User> list = userService.selectAll();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
