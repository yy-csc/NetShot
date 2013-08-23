package com.netshot.dao.impl;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;

import com.netshot.model.Users;
import com.netshot.dao.UsersDao;

@SuppressWarnings("unchecked")
@Repository("usersDao")
public class UsersDaoHibernate extends GeneralDaoHibernate implements UsersDao {

	@Override
	public List isRegister(Users users) {
		return findByPropertys("Users",
				new String[] { "username", "password" },
				new String[] { users.getUsername(), users.getPassword() });
	}

	@Override
	public List isUserExist(Users users) {
		return findByPropertys("Users",
				new String[] { "username"},
				new String[] { users.getUsername()});
	}

}
