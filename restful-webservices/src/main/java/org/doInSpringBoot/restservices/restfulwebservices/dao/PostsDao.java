package org.doInSpringBoot.restservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.Posts;
import org.doInSpringBoot.restservices.restfulwebservices.responsebeans.User;

public class PostsDao {
	
	private static List<Posts> postsList = new ArrayList<>();

	public PostsDao() {	}
	
	static {
		postsList.add(new Posts(1, new Date(),new User(1,"Dhiren",new Date())));
		postsList.add(new Posts(2, new Date(),new User(1,"Dhiren",new Date())));
		postsList.add(new Posts(3, new Date(),new User(1,"Dhiren",new Date())));
		postsList.add(new Posts(4, new Date(),new User(3,"Anushka",new Date())));
		postsList.add(new Posts(5, new Date(),new User(3,"Anushka",new Date())));
		postsList.add(new Posts(6, new Date(),new User(2,"Virat",new Date())));
		postsList.add(new Posts(7, new Date(),new User(4,"Swati",new Date())));
		postsList.add(new Posts(8, new Date(),new User(5,"Disha",new Date())));
		postsList.add(new Posts(9, new Date(),new User(5,"Disha",new Date())));
		postsList.add(new Posts(10, new Date(),new User(1,"Dhiren",new Date())));
	}
	
	
	
}
