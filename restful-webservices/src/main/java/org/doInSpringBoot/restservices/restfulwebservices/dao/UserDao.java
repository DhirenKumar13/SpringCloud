package org.doInSpringBoot.restservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.User;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.UserBean;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	private static List<User> userList = new ArrayList<>();
	private static List<UserBean> userBeanList = new ArrayList<>();
	private static Integer studentId = 5;
	
	static {
		userList.add(new User(1,"Dhiren",new Date()));
		userList.add(new User(2,"Virat",new Date()));
		userList.add(new User(3,"Anushka",new Date()));
		userList.add(new User(4,"Swati",new Date()));
		userList.add(new User(5,"Disha",new Date()));
		
		userBeanList.add(new UserBean(11,"Varsha",new Date()));
		userBeanList.add(new UserBean(21,"Akshay",new Date()));
		userBeanList.add(new UserBean(31,"Priyanka",new Date()));
		userBeanList.add(new UserBean(41,"Aakash",new Date()));
		userBeanList.add(new UserBean(51,"Saloni",new Date()));
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public User save(User user) {
		if(user.getId() == null)
			user.setId(++studentId);
		userList.add(user);
		return user;
	}
	
	public User findOne(Integer id) {
		return userList.stream().filter(
					user -> user.getId() == id
				)
				.findAny()
				.orElse(new User(0,"Default",new Date()));
		
	}
	
	public UserBean findOneBean(Integer id) {
		return userBeanList.stream().filter(
					user -> user.getId() == id
				)
				.findAny()
				.orElse(new UserBean(0,"Default",new Date()));
		
	}
	
	public User deleteOne(Integer id) {
		
		Boolean ifFound = userList.stream()
				.anyMatch(u -> u.getId() == id);
		
		if(ifFound) {
			
			User userTobeDeleted = userList.stream().filter(user -> user.getId() == id).findAny().get();
			
			List<User> collect = userList.stream().filter(
					user -> user.getId() != id
			).collect(Collectors.toList());
			userList = collect;
			return userTobeDeleted;
		}
		
		return null;
	}

	public List<UserBean> findAllUserBean() {
		return userBeanList;
	}
}
