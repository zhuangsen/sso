package demo1.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import demo1.x.com.utils.Demo1Tool;

public class Demo1Action extends ActionSupport {

	private static final long serialVersionUID = -5506581502225757700L;

	private String gotoUrl;

	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ssocookie") && cookie.getValue().equals("sso")) {
					String result = Demo1Tool.doGet("http://check.x.com:9090"+path+"/xsso/checkCookie.action", cookie.getName(),
							cookie.getValue());
					if (result.equals("1")) {
						return SUCCESS;
					}
				}
			}
		}
		gotoUrl = "http://demo1.x.com:9090"+path+"/xdemo1/main.action";
		return LOGIN;
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
}
