package com.zs.sso_learn;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SSOAction extends ActionSupport {

	private static final long serialVersionUID = 8045320994980407383L;

	private String username;
	private String password;
	private String gotoUrl;

	public String doLogin() {
		boolean ok = SSOCheck.checkLogin(username, password);
		if (ok) {
			Cookie cookie = new Cookie("ssocookie", "sso");
			cookie.setPath("/");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.addCookie(cookie);
			return SUCCESS;
		}
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

}
