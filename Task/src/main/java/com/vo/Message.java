package com.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * ǰ̨��Ϣ���ض���
 * @author Leo
 *
 */
public class Message {

	private String welcome;//��ӭ �������
	private List<String> username;//�û��б�
	private String content;//�û�˵����ϸ����
	
	private static Gson gson = new Gson();
	
	public String tojson() {
		return gson.tojson(this);//this��ʾ��ǰ����  ��gson����ȥ
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
