package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.vo.Message;

/**
 * Endpoint指的是一个webSocket服务端程序
 * @author Leo
 *
 */
@ServerEndpoint("/chatSocket")
public class ChatSocket {
	private String username;//设置为全局变量 当前用户
	private static List<Session> sessions = new ArrayList<>();
//静态 全局变量 List
	private static List<String> names = new ArrayList<String>();
	
	
	//获取用户登录信息 且把用户添加到用户列表中
	//发送广播 欢迎广播 把用户添加到用户列表中
	//拿到用户信息  获取Session 通讯管理的对象
	@OnOpen
	public void open(Session session) {
		//获取url每步传过来的参数
		String queryString = session.getQueryString();
		System.out.println(queryString);
		//拿到用户名 url中？username=zhangsan  获取=后面的字符用户名
		String username = queryString.split("=")[1];
		names.add(username);
		sessions.add(session);
		String msg = "欢迎"+username+"进入聊天室";
		//因为发送到前台的数据除了String还有集合List(用户名集合）
		//所以选择发送Json数据  googlejar包
		Message message = new Message();
		message.setWelcome(msg);
		message.setUsername(names);
//		Gson gson = new Gson();
//		gson.tojson(massage);
		broadcast(sessions,message.tojson());
	}
	/**
	 * 发送广播
	 */
	public void broadcast(List<Session> broadcast , String msg) {
		//for循环每次拿到一个session   单独进行广播
	for (Iterator iterator = broadcast.iterator(); iterator.hasNext();) {
		Session session = (Session) iterator.next();
		try {
			session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	}
	/**
	 * 群发
	 */
	@OnMessage
	public void message(Session session,String msg) {
		Message message = new Message();
		message .setContent(username,msg);
		broadcast(sessions,message.tojson());
	}
}
