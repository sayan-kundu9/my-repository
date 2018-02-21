package jbr.springmvc.dao;

import java.util.List;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

	void register(User user);
	
	User validateUser(Login login);
	
	public List<User> getUsers();
	
	public void delete(String username);
	
	public int update(User user);
	public User getUserByUsername(String username);
}
