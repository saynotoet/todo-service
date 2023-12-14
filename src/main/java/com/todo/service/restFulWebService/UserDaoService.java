package com.todo.service.restFulWebService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	private static int usersCount=0;
	private static List<User> users=new ArrayList<>();
	
	static {
		
		users.add(new User(++usersCount,"Abdullah",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Hamza",LocalDate.now().minusYears(27)));
		users.add(new User(++usersCount,"Ali",LocalDate.now().minusYears(26)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId()==id;
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	public void deleteUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId()==id;
		users.removeIf(predicate);
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		
		return user;
	}
}
