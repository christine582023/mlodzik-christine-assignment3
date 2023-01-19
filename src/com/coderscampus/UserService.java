package com.coderscampus;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
	public void UserLoginApplication() {
	}
	
	public User[] getUser() {
		return null;
	}
	
	private final ArrayList<User> users;
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public UserService() {
		this.users = new ArrayList<>();
	}


	public void addUserFromData(String string) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] userData = line.split(",");
				String username = userData[0];
				String password = userData[1];
				String name = userData[2];
				User user = new User(username, password, name);
				users.add(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean matchUser(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
}
