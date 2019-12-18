package com.wonders.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.wonders.springdatajpa.dao.UserDao;
import com.wonders.springdatajpa.entity.User;

import java.util.List;

import javax.transaction.Transactional;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findNameAndPassword(String name,String password){
        return userDao.findByNameAndPassword(name, password);
    }
    
    @Transactional
    public List<User> list(){
        List<User> list = (List<User>) userDao.findAll();
        try {
        	
        	//springdata jpa 保存存在问题,数据没有写入数据库
        	User user = userDao.save(new User(3,"jack","12345"));
        	System.out.println(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        return list;
    }
    
    
}
