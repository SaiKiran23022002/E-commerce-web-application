package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Users;

public interface UserService {

	public List<Users> getUser();

	public Users getUser(long id);

	public Users addUser(Users user);

	public Users updateUser(Users user, long id);

	public void deleteUser(long id);

}
