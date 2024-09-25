package com.food.DAO;
import com.food.model.User;
import java.util.List;
public interface UserDAO {
	int addUser(User user);
	
	User getUser(String email);
	
	void updateUser(User user);
	
	void deleteUser(int user);
	
	List<User> getAllUser();
}
