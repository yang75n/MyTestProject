package com.yqw.spring.hibernate.dao;


import com.yqw.spring.hibernate.domain.Users;

import java.util.List;

/**
 *
 */
public interface UsersDao {
	
	void insertUsers(Users users);
	void updateUsers(Users users);
	void deleteUsers(Users users);
	Users selectUsersById(Integer userid);
	
	List<Users> selectUserByName(String username);
	
	List<Users> selectUserByNameUseSQL(String username);
	
	List<Users> selectUserByNameUseCriteria(String username);
}
