package service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginService {

	public ModelAndView doLogin(String loginPageUrl, String userCenterUrl, String uname, String upassword) {
		if(uname==null || "".equals(uname)) {
			return new ModelAndView(loginPageUrl,"error","�û�������Ϊ��");//���ص�¼���澯�治��Ϊ��
		}
		if(upassword==null || "".equals(upassword)) {
			return new ModelAndView(loginPageUrl,"error","���벻��Ϊ��");
		}
		//����û����������Ƿ���ȷ
		if(uname.equals("admin") && upassword.equals("123")){
			return new  ModelAndView(userCenterUrl);
		}
		return new ModelAndView(loginPageUrl,"error","�û������������") ;
	}

}
