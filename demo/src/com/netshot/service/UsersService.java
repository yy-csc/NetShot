package com.netshot.service;

import com.netshot.model.Users;

public interface UsersService {

	public boolean isRegister(Users users);
	public boolean isUserExist(Users users);
	void createNewUser(Users users);

}
