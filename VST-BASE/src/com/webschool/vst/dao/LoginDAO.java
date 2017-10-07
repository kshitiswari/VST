package com.webschool.vst.dao;

import com.webschool.vst.model.LoginModel;

public interface LoginDAO {

	public boolean addUser(LoginModel user);
	public LoginModel login(String userid);
}
