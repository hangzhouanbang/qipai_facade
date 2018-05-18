package com.anbang.qipai.controller.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Spring WebSocket的配置，这里采用的是注解的方式
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// 1.注册WebSocket
		String websocket_url = "/websocket/socketServer"; // 设置websocket的地址
		registry.addHandler(webSocketHandler(), websocket_url).setAllowedOrigins("*");// 注册Handler
	}

	@Bean
	public TextWebSocketHandler webSocketHandler() {
		return new TestController();
	}

}
