package com.project.websocket;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import  com.project.controller.LoginModel;
import com.project.util.CommonVal;
import com.project.util.Cache;
import com.project.util.CacheManage;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.springframework.web.servlet.HandlerMapping;
import java.util.Set;
/**
* Socket建立连接（握手）和断开
*/
public class ChatWebSocketShake implements HandshakeInterceptor {
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			Map<String, String> maps =  getParamters( servletRequest);
			LoginModel login2=null;
			if(maps.get("loginToken")!=null&&maps.get("loginToken").equals("")==false){
				String val = maps.get("loginToken");
				Cache loginCache = CacheManage.getCacheInfo(val);
				if(loginCache!=null){
					login2 = (LoginModel)loginCache.getValue();
					servletRequest.getServletRequest().getSession().setAttribute(CommonVal.sessionName, login2);//设置登录session，保持会话
				}
			}
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			LoginModel login = (LoginModel) session
			.getAttribute(CommonVal.sessionName); //获取当前登录账号信息
			// 标记用户
			if(login!=null){
				attributes.put(CommonVal.websocketSessionName, login.getLoginType()+"-"+login.getId());//登录用户session由登录id+登录类型组成
			}else{
				return false;
			}
		}
		return true;
	}
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
	}
	public  Map<String, String>  getParamters(ServletServerHttpRequest request2) {
		HttpServletRequest request = request2.getServletRequest();
		Map<String, String> map = new HashMap<String,String>();
		Enumeration<String> parameterNames =request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			map.put(key, value);
		}
		LinkedHashMap attribute = (LinkedHashMap) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		if(attribute!=null){
			Set<Map.Entry<String, String>> entrySet = attribute.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				map.put(entry.getKey(), entry.getValue());
			}
		}
		return map;
	}
}
