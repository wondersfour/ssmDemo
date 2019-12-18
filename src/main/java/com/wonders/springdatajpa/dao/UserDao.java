package com.wonders.springdatajpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.wonders.springdatajpa.entity.User;


/**
 * 使用springdata jpa 
 * 参考：https://www.cnblogs.com/oukele/p/10156585.html
 * @author zj
 *
 */
public interface UserDao extends CrudRepository<User, Integer>{
	
	User findByNameAndPassword(String name,String password);
}
