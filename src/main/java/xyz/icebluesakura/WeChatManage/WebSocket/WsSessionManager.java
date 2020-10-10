package xyz.icebluesakura.WeChatManage.WebSocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.WebSocketSession;

public class WsSessionManager {
    private static ConcurrentHashMap<String, WebSocketSession> SESSION_POOL = new ConcurrentHashMap();

    public WsSessionManager() {
    }

    public static void add(String key, WebSocketSession session) {
        SESSION_POOL.put(key, session);
    }

    public static WebSocketSession remove(String key) {
        return (WebSocketSession)SESSION_POOL.remove(key);
    }

    public static void removeAndClose(String key) {
        WebSocketSession session = remove(key);
        if (session != null) {
            try {
                session.close();
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

    }

    public static WebSocketSession get(String key) {
        return (WebSocketSession)SESSION_POOL.get(key);
    }
}
