package andy.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * https://blog.csdn.net/xiaojiesu/article/details/50555714 取消了NotEmpty
 * 可以参考上边链接
 * @author zj
 *
 */
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_user")
public class User1 {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 100)
	//@NotEmpty(message = "用户名不能为空")
	private String userName;  //用户名

	@Column(length = 100)
	//@NotEmpty(message = "密码不能为空")
	private String password;  //密码
	
	@Column(length = 1000)
	private String remarks; // 备注
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User1() {
		super();
	}

}
