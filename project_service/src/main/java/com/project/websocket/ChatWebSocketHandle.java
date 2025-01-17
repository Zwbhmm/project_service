package com.project.websocket;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.dao.*;
import com.project.service.*;
import com.project.model.*;
import com.project.controller.*;
import com.project.util.PageUtils;
import com.project.util.*;
/**
* Socket处理器
*
*/
@Component
public class ChatWebSocketHandle implements WebSocketHandler {
	@Autowired
	SxLogMapper sxLogMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	ChatChatService chatChatService;
	public static final Map<String, WebSocketSession> userSocketSessionMap;
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String defaultImg = "http://"+CommonVal.hostPort+"/project_service/static/pcchat/img/em_02.jpg";
	static {
		userSocketSessionMap = new HashMap<String, WebSocketSession>();
	}
	/**
	* 建立连接后
	*/
	public void afterConnectionEstablished(WebSocketSession session)
	throws Exception {
		String uid =  session.getAttributes().get(CommonVal.websocketSessionName).toString();
		if (userSocketSessionMap.get(uid) == null) {
			userSocketSessionMap.put(uid+"-Session", session);
		}
	}
	/**
	* 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	*/
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if(message.getPayloadLength()==0)return;
		Map<String,Object> msg=JsonUtil.jsonToMap(message.getPayload().toString());//获取到客户端发来的消息
		String sendId =  session.getAttributes().get(CommonVal.websocketSessionName).toString();
		String sendId2 = sendId.split("-")[1];
		List<String> uids = new ArrayList<String>();
		Map<String,Object> msg2 = new HashMap<String,Object>();
		String receiveId = msg.get("receiveId").toString();
		SxLog log = new SxLog();
		User send = userMapper.selectByPrimaryKey(Integer.parseInt(sendId2));
		log.setUid(Integer.parseInt(sendId2));
		log.setUid1(Integer.parseInt(receiveId));
		log.setIsRead(2);//设为未读
		msg2.put("sendName",send.getLoginName());
		msg2.put("sendId",send.getId());
		msg2.put("createTime",sdf1.format(new Date()));
		msg2.put("log", msg.get("sendMsg").toString());
		msg2.put("receiveId",receiveId);
		receiveId = "2-"+receiveId;
		uids.add(receiveId);
		log.setContent(msg.get("sendMsg").toString());
		//处理消息
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		while (it.hasNext()) {
			final Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().isOpen()) {
				if(entry.getKey().equals(receiveId+"-Session")){
					uids.add(entry.getKey());
				}
			}
		}
		sendMsgToUser(msg2,uids);//将消息传输给指定用户
		log.setCreateTime(sdf1.format(new Date()));
		sxLogMapper.insertSelective(log);
	}
	/**
	* 发送消息给用户
	* @param msg
	* @param userIds,users的字符串由userId+'-'+loginType组成
	*/
	private void sendMsgToUser(Object msg,List<String> users){
		for(String userId:users){
			final TextMessage message = new TextMessage(new GsonBuilder().create().toJson(msg));
			Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
			while (it.hasNext()) {
				final Entry<String, WebSocketSession> entry = it.next();
				if (entry.getValue().isOpen()&&entry.getKey().equals(userId)) {
					new Thread(new Runnable() {
						public void run() {
							try {
								if (entry.getValue().isOpen()) {
									entry.getValue().sendMessage(message);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}).start();
				}
			}
		}
	}
	/**
	* 消息传输错误处理
	*/
	public void handleTransportError(WebSocketSession session,
	Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap
		.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}
	/**
	* 关闭连接后
	*/
	public void afterConnectionClosed(WebSocketSession session,
	CloseStatus closeStatus) throws Exception {
		if(session.isOpen()==false){
			return;
		}
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap
		.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<String, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}
	public boolean supportsPartialMessages() {
		return false;
	}
}
