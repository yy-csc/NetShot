package com.netshot.dao;

import java.util.List;

import com.netshot.model.Users;

public interface UsersDao extends GeneralDao {

	public List isRegister(Users users);
	public List isUserExist(Users users);

}
