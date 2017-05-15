package www.b.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import www.b.com.utils.Demo2Tool;


public class Demo2Action extends ActionSupport {

	private static final long serialVersionUID = -5506581502225757700L;
	
	private String username;
	private String password;
	private String gotoUrl;
	private String path;
	private List<String> hiddenUrl;
	
	public String main() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path1 = request.getContextPath();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ssocookie") && cookie.getValue().equals("sso")) {
					Map<String, String> map = new HashMap<>();
					map.put("cookieName", cookie.getName());
					map.put("cookieValue", cookie.getValue());
					String result = Demo2Tool.doGet("http://www.x.com:9090"+path1+"/csso/checkCookie.action", map);
					if (result.equals("1")) {
						return SUCCESS;
					}
				}
			}
		}
		path = "http://www.b.com:9090"+path1+"/cdemo2";
		gotoUrl = "http://www.b.com:9090"+path1+"/cdemo2/main.action";
		return LOGIN;
	}

	public String doLogin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getContextPath();
		Map<String,String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		String result = Demo2Tool.doGet("http://www.x.com:9090"+path+"/csso/doLogin.action", map);
		if(result.equals("1")){
			hiddenUrl = new ArrayList<>();
			hiddenUrl.add("http://www.a.com:9090"+request.getContextPath()+"/cdemo1/addCookie.action");
			hiddenUrl.add("http://www.b.com:9090"+request.getContextPath()+"/cdemo2/addCookie.action");
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public void addCookie(){
		Cookie cookie = new Cookie("ssocookie", "sso");
		cookie.setPath("/");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.addCookie(cookie);
	}

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<String> getHiddenUrl() {
		return hiddenUrl;
	}

	public void setHiddenUrl(List<String> hiddenUrl) {
		this.hiddenUrl = hiddenUrl;
	}
	
}
