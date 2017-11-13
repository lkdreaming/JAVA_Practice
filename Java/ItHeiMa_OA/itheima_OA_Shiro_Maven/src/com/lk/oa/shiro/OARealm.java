package com.lk.oa.shiro;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.lk.oa.model.Privilege;
import com.lk.oa.model.User;
import com.lk.oa.service.LoginService;
import com.lk.oa.service.PrivilegeService;

public class OARealm extends AuthorizingRealm {
	private LoginService loginService;
	private PrivilegeService privilegeService;
	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}
	
	@Resource(name = "privilegeService")
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	@Resource(name = "loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		Collection<Privilege> privileges = null;
		privileges = this.privilegeService.getPrivilegesByUserId(user.getUserId());
		for(Privilege privilege : privileges) {
			authorizationInfo.addStringPermission(privilege.getName());
		}
		return authorizationInfo;
	}

	/**
	 * 查询是否有相应的Entity
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
		AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		User user = this.loginService.queryEntryByProperty(usernamePasswordToken.getUsername());
		if(user == null) {
			return null;
		} else {
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			return authenticationInfo;
		}
		
		/*String username = (String)token.getPrincipal();  				//得到用户名 
	    String password = new String((char[])token.getCredentials()); 	//得到密码
	    if(null != username && null != password){
	    	return new SimpleAuthenticationInfo(username, password, getName());
	    }else{
	    	return null;
	    }*/
		
	}
	
}
