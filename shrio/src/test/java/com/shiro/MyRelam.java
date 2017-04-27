package com.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRelam implements Realm{

	
	public String getName() {
		return "MyRelam1";
	}

	
	public boolean supports(AuthenticationToken token) {
		//仅支持userNamePasswordToken类型的token
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String) token.getPrincipal();//得到用户名
		String passworl= new String((char[])token.getCredentials());
		if(!"zhang".equals(username)){
			throw new UnknownAccountException();
		}
		if(!"123".equals(passworl)){
			throw new IncompatibleClassChangeError();
		}
		//如果通过验证，则返回一个
		return new SimpleAuthenticationInfo(username,passworl,getName());
	}

}
