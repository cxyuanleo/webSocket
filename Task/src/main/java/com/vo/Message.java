package com.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 前台消息返回对象
 * @author Leo
 *
 */
public class Message {

	private String welcome;//欢迎 欢送语句
	private List<String> username;//用户列表
	private String content;//用户说的详细内容
	
	private static Gson gson = new Gson();
	
	public String tojson() {
		return gson.tojson(this);//this表示当前对象  把gson丢进去
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public List<String> getUsername() {
		return username;
	}
	public void setUsername(List<String> username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setContent(String name,String content) {
		this.content =name+""+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(0))+content;
	}
}
