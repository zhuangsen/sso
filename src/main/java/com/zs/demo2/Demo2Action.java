package com.zs.demo2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.sso_learn.SSOCheck;

public class Demo2Action extends ActionSupport {

	private static final long serialVersionUID = -5506581502225757700L;
	
	private String gotoUrl;

	public String main(){
		HttpServletRequest request = ServletActionContext.getRequest();
		if(SSOCheck.checkCookie(request)){
			return SUCCESS;
		}
		gotoUrl = "/demo2/main.action";
		return LOGIN;
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
}
