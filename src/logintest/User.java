package logintest;

import java.io.Serializable;

/**
 * 用户实体类，实现序列化
 * @author zhangsan
 * @version 1.0 User.java
 * @date 上午09:36:38
 *
 */
public class User implements Serializable{
	
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
