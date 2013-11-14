package com.contacttest.contact.daoImpl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.contacttest.contact.dao.UsersDao;
import com.contacttest.contact.domain.Users;

@Repository
public class UsersDaoImpl extends SqlSessionDaoSupport implements UsersDao {
	
	public UsersDaoImpl() {
		System.out.println("UserDaoImpl start...");
	}

	@Override
	public Integer insertUsers(Users users) throws Exception {
		return (Integer) getSqlSession().insert("com.contacttest.contact.dao.UsersDao.insertUsers", users);
	}

	@Override
	public Users getUsers(Users users) throws Exception {
		return (Users)getSqlSession().selectOne("com.contacttest.contact.dao.UsersDao.getUsers", users);
	}

	@Override
	public int updateUsers(Users users) throws Exception {
		return getSqlSession().update("com.contacttest.contact.dao.UsersDao.updateUsers", users);
	}

	@Override
	public int deleteUsers(Users users) throws Exception {
		return getSqlSession().delete("com.contacttest.contact.dao.UsersDao.deleteUsers", users);
	}

	
	// 이메일 아이디로만 유저 체크
	@Override
	public Users checkUsers(Users users) throws Exception {
		return (Users)getSqlSession().selectOne("Users.checkUsers", users);
	}
}