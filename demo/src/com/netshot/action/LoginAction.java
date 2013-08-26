package com.netshot.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.netshot.model.Users;
import com.netshot.service.UsersService;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FORWARD_FAIL = "fail";
	public static final String ISFIRSTLOGIN = "firstLogin";

	@Autowired
	private UsersService usersService;
	private Users users;

	/**
	 * Description: Login operation.
	 * 
	 * @param null
	 * @return String
	 * @throws Exception
	 */
	public String execute() {
		String path = getRequest().getScheme() + "://"
				+ getRequest().getServerName() + ":"
				+ getRequest().getServerPort() + getRequest().getContextPath()
				+ "/";
		getSession().setAttribute("path", path);
		if (usersService.isRegister(users)) {
			getSession().setAttribute("userName", users.getUsername());
			return SUCCESS;
		}
		return FORWARD_FAIL;
	}

	public String logout() throws Exception {
		getSession().removeAttribute("path");
		getSession().removeAttribute("userName");
		return FORWARD_FAIL;
	}

	public String register() {
		if (users.getUsername() != null) {
			if (usersService.isUserExist(users)) {
				addActionMessage("该用户名已被注册!");
				return "fail";
			} else {
				usersService.createNewUser(users);
				return SUCCESS;
			}
		} else {
			return "fail";
		}
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

}