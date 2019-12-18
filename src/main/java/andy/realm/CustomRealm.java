package andy.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import andy.model.User;
import andy.service.ShiroUserService;


/**
 * 
 * 参考：https://www.cnblogs.com/zhukaixin/p/9437059.html
 * 自定义的realm
 * @author zj
 *
 */
public class CustomRealm extends AuthorizingRealm{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);
	
	@Autowired
	private ShiroUserService shiroUserService;

	
	/**
	 * 用户授权认证
	 * 
	 * 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		logger.info("=============>用户授权认证<==========");
		System.out.println("==============>>用户授权认证<<==============");
		String username = principalCollection.getPrimaryPrincipal().toString();
		System.out.println("===>授权>"+username);
		SimpleAuthorizationInfo simpleAuthorizationInfo  = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(shiroUserService.queryRolesByName(username));
		
		return simpleAuthorizationInfo;
	}
	
	/**
	 * 用户登录认证
	 */
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		logger.info("======用户登陆认证======");
	
		
		String userName = authenticationToken.getPrincipal().toString();
        User user = shiroUserService.queryUserByName(userName);
        System.out.println(userName+"===============>>thisisUserNamme<<=================="+user);
		if (user!=null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
            return authenticationInfo;
        }
        return null;
	}

}
