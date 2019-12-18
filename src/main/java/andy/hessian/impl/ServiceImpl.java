package andy.hessian.impl;

import andy.hessian.IService;
import andy.model.HessianUser;

public class ServiceImpl implements IService {

	@Override
	public HessianUser getUser() {
		// TODO Auto-generated method stub
		return new HessianUser("孤傲沧浪");
	}

}
