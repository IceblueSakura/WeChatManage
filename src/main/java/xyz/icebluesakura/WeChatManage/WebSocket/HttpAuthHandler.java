package xyz.icebluesakura.WeChatManage.WebSocket;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class HttpAuthHandler extends TextWebSocketHandler {
    public HttpAuthHandler() {
    }

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("登录完成");
        WsSessionManager.add("testUser", session);
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = (String)message.getPayload();
        Object token = session.getAttributes().get("token");
        System.out.println("server 接收到 " + token + " 发送的 " + payload);
        session.sendMessage(new TextMessage("server 发送给 " + token + " 消息 " + payload + " " + LocalDateTime.now().toString()));
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Object token = session.getAttributes().get("token");
        if (token != null) {
            WsSessionManager.remove(token.toString());
        }

    }
}
