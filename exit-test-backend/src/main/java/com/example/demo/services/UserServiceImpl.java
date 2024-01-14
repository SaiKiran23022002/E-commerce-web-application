package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsersRepo;
import com.example.demo.entities.Users;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepo usersRepo;
	List<Users> list;
	private long nextId = 0;

	public UserServiceImpl() {

		list = new ArrayList<>();
		list.add(createUser("saikiranbommuluri08@gmail.com", "Saikiran@08", "Sai", "Kiran", 9573072966L));

		list.add(createUser("vinodasapu@gmail.com", "Vinod@41", "Vinod", "Asapu", 9132149318L));

	}

	@PostConstruct
	public void init() {
		// Check if the database is empty
		if (usersRepo.count() == 0) {
			List<Users> dummyData = createDummyData();
			usersRepo.saveAll(dummyData);
		}
	}

	private List<Users> createDummyData() {
		List<Users> dummyData = new ArrayList<>();
		dummyData.add(createUser("saikiranbommuluri08@gmail.com", "Saikiran@08", "Sai", "Kiran", 9573072966L));
		dummyData.add(createUser("vinodasapu@gmail.com", "Vinod@41", "Vinod", "Asapu", 9132149318L));
		return dummyData;
	}

	private Users createUser(String email, String password, String firstname, String lastname, long number) {
		long id = nextId;
		nextId++;
		return new Users(email, password, firstname, lastname, number, id);
	}

	@Override
	public List<Users> getUser() {
		return (List<Users>) usersRepo.findAll();

	}

	@Override
	public Users getUser(long id) {
		// TODO Auto-generated method stub

		return usersRepo.findById(id).orElse(null);
	}

	@Override
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		long id = nextId;
		user.setId(id);
		nextId++;
		list.add(user);
		return usersRepo.save(user);
	}

	@Override
	public Users updateUser(Users user, long id) {
		// TODO Auto-generated method stub
		if (usersRepo.existsById(id)) {
			user.setId(id);
			return usersRepo.save(user);
		}
		return null;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		usersRepo.deleteById(id);

	}

}
