package andy.service;

import java.util.Set;

import andy.model.User;

public interface ShiroUserService {
	
	public User queryUserByName(String userName);
	
	public Set<String> queryRolesByName(String userName);
}
