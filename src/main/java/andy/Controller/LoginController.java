package andy.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import andy.model.User;
import andy.realm.CustomRealm;
import andy.service.ShiroUserService;

/**
 * shiro权限登录控制层
 * @author zj
 * 
 * https://www.cnblogs.com/zhukaixin/p/9437059.html
 *
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ShiroUserService shiroUserService;
	
	@RequestMapping("/index")
	public String index(){
		return "/login";
	}
	
	
	@RequestMapping("/login")
    public String login(User user,Model model){
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken usernamePasswordToken  = new UsernamePasswordToken(user.getUserName(),user.getPassword());
		
		try {
			subject.login(usernamePasswordToken);
			// 输出日志
			logger.info("测试：{}", "输出成功日志");
			return "/success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			// 输出日志
			logger.info("测试：{}", "输出失败日志");
			return "/login";
		}
		
		
	}
}
