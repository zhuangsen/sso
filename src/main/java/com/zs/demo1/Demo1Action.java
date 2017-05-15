package com.zs.demo1;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zs.sso_learn.SSOCheck;

public class Demo1Action extends ActionSupport {

	private static final long serialVersionUID = -5506581502225757700L;
	
	private String gotoUrl;

	public String main(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

		System.out.println(basePath);
		
		if(SSOCheck.checkCookie(request)){
			return SUCCESS;
		}
		gotoUrl = "/demo1/main.action";
		return LOGIN;
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
}
