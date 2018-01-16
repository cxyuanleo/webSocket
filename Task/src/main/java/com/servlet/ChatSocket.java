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
 * Endpointָ����һ��webSocket����˳���
 * @author Leo
 *
 */
@ServerEndpoint("/chatSocket")
public class ChatSocket {
	private String username;//����Ϊȫ�ֱ��� ��ǰ�û�
	private static List<Session> sessions = new ArrayList<>();
//��̬ ȫ�ֱ��� List
	private static List<String> names = new ArrayList<String>();
	
	
	//��ȡ�û���¼��Ϣ �Ұ��û���ӵ��û��б���
	//���͹㲥 ��ӭ�㲥 ���û���ӵ��û��б���
	//�õ��û���Ϣ  ��ȡSession ͨѶ����Ķ���
	@OnOpen
	public void open(Session session) {
		//��ȡurlÿ���������Ĳ���
		String queryString = session.getQueryString();
		System.out.println(queryString);
		//�õ��û��� url�У�username=zhangsan  ��ȡ=������ַ��û���
		String username = queryString.split("=")[1];
		names.add(username);
		sessions.add(session);
		String msg = "��ӭ"+username+"����������";
		//��Ϊ���͵�ǰ̨�����ݳ���String���м���List(�û������ϣ�
		//����ѡ����Json����  googlejar��
		Message message = new Message();
		message.setWelcome(msg);
		message.setUsername(names);
//		Gson gson = new Gson();
//		gson.tojson(massage);
		broadcast(sessions,message.tojson());
	}
	/**
	 * ���͹㲥
	 */
	public void broadcast(List<Session> broadcast , String msg) {
		//forѭ��ÿ���õ�һ��session   �������й㲥
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
	 * Ⱥ��
	 */
	@OnMessage
	public void message(Session session,String msg) {
		Message message = new Message();
		message .setContent(username,msg);
		broadcast(sessions,message.tojson());
	}
}
