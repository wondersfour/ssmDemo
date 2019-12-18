package andy.Controller;
import java.util.List;

import andy.model.UserInfo;
import andy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
/**  
 *�ο����ӣ�
 *	https://blog.csdn.net/fengshizty/article/details/43086961
 *	��������:.do������ʲ���
 *
 *http://blog.sina.com.cn/s/blog_6b6ab0890101hg0f.html
 */
@Controller
@RequestMapping("/user")
public class UserController {
 
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
		UserInfo userInfo = userService.getUserById(userId);
		modelMap.addAttribute("userInfo", userInfo);
		return "/user/showInfo";
	}
	
	@RequestMapping("/showInfos")
	public @ResponseBody Object showUserInfos(){
		List<UserInfo> userInfos = userService.getUsers();
		return userInfos;
	}
	
	@RequestMapping("/test.do")
	public void test(){
		UserInfo userInfo = new UserInfo();
		userInfo.setUname("这是中文名字");
		userInfo.setUnumber(26);
		int result = userService.insert(userInfo);
		System.out.println(result+"============>>这里是中文");
	}

}
