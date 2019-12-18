package andy.hessian;

import andy.model.HessianUser;



/**
 * hessian服务端开发 参考：https://www.cnblogs.com/xdp-gacl/p/3897534.html
 * @author zj
 *
 */
public interface IService {
	
	public HessianUser getUser();

}
