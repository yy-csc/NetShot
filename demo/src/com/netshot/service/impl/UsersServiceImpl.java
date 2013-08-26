package com.netshot.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.net.ntp.TimeStamp;
import org.appfuse.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netshot.dao.UsersDao;
import com.netshot.dao.impl.UsersDaoHibernate;
import com.netshot.model.Users;
import com.netshot.service.*;

@Service("usersService")
@WebService(serviceName = "UsersService", endpointInterface = "com.netshot.service.UsersService")
public class UsersServiceImpl implements UsersService {

	@Resource
	UsersDao usersDao;

	public UsersServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isRegister(Users users) {
		List rs = usersDao.isRegister(users);
		if (rs != null && rs.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUserExist(Users users) {
		List rs = usersDao.isUserExist(users);
		if (rs != null && rs.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void createNewUser(Users users) {
		users.setCredits(10);
		users.setLoginTs(new Timestamp(new Date().getTime()));
		usersDao.save(users);
	}
}
