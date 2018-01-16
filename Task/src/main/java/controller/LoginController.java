//package controller;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import service.LoginService;
//
//@Controller
//@RequestMapping("/task/home")
//public class LoginController {
//
//	@Resource
//	LoginService loginservice;
//	@Resource
//	HttpServletRequest request;
//	
//	@RequestMapping("/index")
//	public ModelAndView homePage() {
//		return new ModelAndView("WEB-INF/jsp/home.jsp");
//	}
//	@RequestMapping("/login")
//	public ModelAndView login() {
//		String loginPageUrl = "/WEB-INF/jsp/user/login";
//		String userCenterUrl="/WEB-INF/jsp/user/userCenter";
//		String uname = request.getParameter("uname");
//		String upassword = request.getParameter("upassword");
//		return loginservice.doLogin(String loginPageUrl,String userCenterUrl,String uname,String upassword); 
//	}
//}
