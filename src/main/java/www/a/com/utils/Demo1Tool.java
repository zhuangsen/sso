package www.a.com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class Demo1Tool {

	public static String doGet(String url, Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpURLConnection = null;
		try {
			StringBuffer t_s = new StringBuffer(url).append("?");
			for(Map.Entry<String, String> entry:map.entrySet()){
				t_s.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			url = t_s.substring(0,t_s.length()-1);
			URL urls = new URL(url);
			httpURLConnection = (HttpURLConnection) urls.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			InputStream in = httpURLConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			isr.close();
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(httpURLConnection!=null){
				httpURLConnection.disconnect();
			}
		}
		return sb.toString();
	}
}
