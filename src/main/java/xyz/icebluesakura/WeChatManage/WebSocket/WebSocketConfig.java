package xyz.icebluesakura.WeChatManage.WebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private HttpAuthHandler httpAuthHandler;
    private MyInterceptor myInterceptor;

    @Autowired
    public WebSocketConfig(HttpAuthHandler httpAuthHandler, MyInterceptor myInterceptor) {
        this.httpAuthHandler = httpAuthHandler;
        this.myInterceptor = myInterceptor;
    }

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.httpAuthHandler, new String[]{"myWS"}).addInterceptors(new HandshakeInterceptor[]{this.myInterceptor}).setAllowedOrigins(new String[]{"*"});
    }
}

