package andy.dao;

import java.util.List;

import andy.model.UserInfo;

public interface UserInfoMapper {
	
	 	int deleteByPrimaryKey(Integer id);
	 
	    int insert(UserInfo record);
	 
	    int insertSelective(UserInfo record);
	 
	    UserInfo selectByPrimaryKey(Integer id);
	 
	    int updateByPrimaryKeySelective(UserInfo record);
	 
	    int updateByPrimaryKey(UserInfo record);
	    
	    List<UserInfo> selectAll();

}