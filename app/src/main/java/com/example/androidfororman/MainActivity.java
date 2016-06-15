package com.example.androidfororman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cn.mydao.UserT;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private SimpleAdapter adapter;
	private List<HashMap<String,String>> mylist;//存放数据
	private HashMap<String,String> map;
	private EditText username;
	private EditText password;
	private EditText email;
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			adapter.notifyDataSetChanged();//处理UI更新
			
			Toast.makeText(MainActivity.this,"更新UI",Toast.LENGTH_SHORT).show();
		}
		
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btninsert = (Button)findViewById(R.id.btninsert);
		Button btnselect = (Button)findViewById(R.id.btnselect);
		Button btnupdate = (Button)findViewById(R.id.btnupdate);
		Button btndelete = (Button)findViewById(R.id.btndelete);
		username = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		email = (EditText)findViewById(R.id.email);
		btninsert.setOnClickListener(this);//CRUD操作
		btnselect.setOnClickListener(this);
		btnupdate.setOnClickListener(this);
		btndelete.setOnClickListener(this);
		mylist= new LinkedList<HashMap<String,String>>();
		map = new HashMap<String,String>();
		map.put("username","temp1");
		map.put("password","temp2");
		map.put("email","temp3");
		mylist.add(map);
		adapter = new SimpleAdapter(this,mylist,R.layout.list,new String[]{"username","password","email"},new int[]{R.id.listusername,R.id.listpassword,R.id.listemail});
		ListView obj = (ListView)findViewById(R.id.list);
		obj.setAdapter(adapter);//设置关联。
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if(id == android.R.id.home)
		{
			//
			return true;//home键按下的情况
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch(id)
		{
		case R.id.btninsert:
			username.getText().toString();
			UserT us = new UserT(username.getText().toString(),password.getText().toString(),email.getText().toString());
			us.save();
			Toast.makeText(MainActivity.this,"插入成功",Toast.LENGTH_SHORT).show();
			Iterator<UserT> tempuser = UserT.findAll(UserT.class);
			mylist.clear();
			while(tempuser.hasNext())
			{
				Toast.makeText(MainActivity.this,"存在数据",Toast.LENGTH_LONG).show();
				map = new HashMap<String,String>();
				UserT ustemp = tempuser.next();
				map.put("username",ustemp.getUsername());
				map.put("password",ustemp.getPassword());
				map.put("email",ustemp.getEmail());
				mylist.add(map);
				adapter.notifyDataSetChanged();//更改数据//每增加一行数据就要改变一次
			}
			
			
		break;
		case R.id.btnselect://查询操作
			
			
		break;
		}
		
	}
}
