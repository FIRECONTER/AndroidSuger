package cn.mydao;

import com.orm.SugarRecord;

public class UserT extends SugarRecord<UserT> {
//构建ORM 框架中的object
	private String username;
	private String password;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public UserT()
	{
		
	}
	public UserT(String username,String password,String email)
	{
		this.username = username;
		this.password = password;
		this.email = email;
	}
	//method
}
