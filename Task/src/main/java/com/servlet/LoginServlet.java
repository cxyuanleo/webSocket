package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���ܽ��ܣ������û���¼���û������������ҳ����ת��������
 * 
 * @author Leo
 *
 */
public class LoginServlet  extends HttpServlet{

	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)  throws ServletException ,IOException {
		String username = req.getParameter("username");
		
		//��ǰ̨jspҳ�洫���û��� username ǰ̨jspҳ��ʹ��: ${sessionScope.user}���յ��û���
		req.getSession().setAttribute("user", username);
		
		//�ض���   ֮�����ֵ�ᶪʧ   ��������session��
		resp.sendRedirect("chatRoom.jsp");
	}
}
