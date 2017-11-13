package com.lk.oa.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = 
				new UsernamePasswordToken(
						this.getModel().getUsername(), 
						this.getModel().getPassword());
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			this.addActionError("该用户名不存在");
			return "login";
		} catch (AuthenticationException e) {
			this.addActionError("密码不正确");
			return "login";
		}
		return "index";
	}
}
