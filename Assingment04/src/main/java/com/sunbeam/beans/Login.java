package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class Login {
	 private String email;
	private String password;
	private User user;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Login() {
		
	}
	
	public void authuser() {
		try(UserDao user= new UserDaoImpl()){ 
			User dbUser = user.findByEmail(this.email);
			if(dbUser!=null && dbUser.getPassword().equals(this.password))
				this.user=dbUser;
			else this.user =dbUser;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
	


