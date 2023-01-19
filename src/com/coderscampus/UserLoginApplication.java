package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		final String BLANK_SPACE = " ";

		UserService userService = new UserService();
		
		userService.addUserFromData("src/com/coderscampus/data.txt");
		
		try (Scanner input = new Scanner(System.in)) {
			int attempts = 0;
			
			while(attempts < 5) {
				
				System.out.println("Enter your username:" + BLANK_SPACE);
				String username = input.nextLine();

				System.out.println("Enter your password:" + BLANK_SPACE);
				String password = input.nextLine();
				
				if (userService.matchUser(username, password)) {
					for (User user : userService.getUsers()) {
						if (user.getUsername().equalsIgnoreCase(username)) {
							System.out.println("Welcome" + BLANK_SPACE + user.getName());
						}
					}
					
					break;
					
				} else {
					attempts++;
					
					if (attempts == 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					} else {
						System.out.println("Invalid login, please try again.");
					}
				}
			}
		}
	}
}