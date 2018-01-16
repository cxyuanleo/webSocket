package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 功能介绍：接收用户登录的用户名和密码进行页面跳转到聊天室
 * 
 * @author Leo
 *
 */
public class LoginServlet  extends HttpServlet{

	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)  throws ServletException ,IOException {
		String username = req.getParameter("username");
		
		//向前台jsp页面传入用户名 username 前台jsp页面使用: ${sessionScope.user}接收到用户名
		req.getSession().setAttribute("user", username);
		
		//重定向   之后参数值会丢失   把它放入session中
		resp.sendRedirect("chatRoom.jsp");
	}
}
