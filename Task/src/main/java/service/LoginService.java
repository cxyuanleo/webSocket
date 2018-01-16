package service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginService {

	public ModelAndView doLogin(String loginPageUrl, String userCenterUrl, String uname, String upassword) {
		if(uname==null || "".equals(uname)) {
			return new ModelAndView(loginPageUrl,"error","用户名不能为空");//返回登录界面警告不能为空
		}
		if(upassword==null || "".equals(upassword)) {
			return new ModelAndView(loginPageUrl,"error","密码不能为空");
		}
		//检测用户名和密码是否正确
		if(uname.equals("admin") && upassword.equals("123")){
			return new  ModelAndView(userCenterUrl);
		}
		return new ModelAndView(loginPageUrl,"error","用户名或密码错误") ;
	}

}
