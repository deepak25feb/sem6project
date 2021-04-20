package com.example.demo.WebSocketLayer;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnOpen;

@ServerEndpoint(value="wsServer")
public class WsServer {
	
	@OnOpen
	public void OnOpen(Session session) {
		System.out.println(session.toString()); 
	}
	
	@OnMessage
	public void onMessage(Session ss,byte[] img) {
		ByteBuffer buf = ByteBuffer.wrap(img);
		try {
			ss.getBasicRemote().sendBinary(buf);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose(Session ss) {
		try {
			ss.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
