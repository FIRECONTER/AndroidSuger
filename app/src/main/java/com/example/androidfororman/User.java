package com.example.androidfororman;

import com.orm.SugarRecord;
//use sugar record 框架
public class User extends SugarRecord<User> {

	//数据库的操作。
	public String username;
	public String password;
	public int age;
	public User()
	{
		
	}
	public User(String username,String password,int age)
	{
		this.username = username;
		this.password = password;
		this.age = age;
	}
	public String  toString()
	{
		return "username"+username+"password"+password+"age"+age;
	}
}
