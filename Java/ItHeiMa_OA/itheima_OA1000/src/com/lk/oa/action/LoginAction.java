package com.lk.oa.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lk.oa.action.base.BaseAction;
import com.lk.oa.model.User;
import com.lk.oa.service.LoginService;
import com.opensymphony.xwork2.ActionContext;

@Component("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	private LoginService loginService;
	
	public String authentication() {
		User user = loginService.anthentication(this.getModel());
		if(user == null) {
			this.addActionError("用户名或密码不正确");
			return "login";
		} else {
			/**
			 * 把user对象写到Session中,以便验证权限使用
			 */
			this.getSession().setAttribute("user", user);
			return "index";
		}
	}

	public LoginService getLoginService() {
		return loginService;
	}
	@Resource(name = "loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
