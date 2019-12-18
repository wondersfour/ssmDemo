package andy.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andy.dao.UserMapper;
import andy.model.User;
import andy.service.ShiroUserService;

@Service
public class ShiroUserServiceImpl implements ShiroUserService {
	
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.queryUserByName(userName);
	}

	@Override
	public Set<String> queryRolesByName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.queryRolesByName(userName);
	}

}
