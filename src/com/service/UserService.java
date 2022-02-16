package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;


import user.UserDAO;
import user.UserDTO;

public class UserService {
	UserDAO dao;
	
	
	public UserService() {
	
	}
	

	public UserDTO login(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		UserDTO dto = null;
		try {
			UserDAO dao = new UserDAO();
			 dto = dao.login(session, map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	

	public int register(UserDTO dto) {
		 SqlSession session = MySqlSessionFactory.getSession();
		  int n = 0;
		  try {
			  UserDAO dao = new UserDAO();
			  n = dao.register(session, dto);
			  session.commit();
		  }finally {
			session.close();
		}
		  return n;
	}
}
