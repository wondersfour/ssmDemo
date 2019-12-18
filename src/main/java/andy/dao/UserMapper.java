package andy.dao;

import java.util.Set;

import andy.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public User queryUserByName(String userName);
    
    public Set<String> queryRolesByName(String userName);
}