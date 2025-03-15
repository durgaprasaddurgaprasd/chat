package com.realtimechat.config;  // ✅ Correct package declaration

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class MessageConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // Clients subscribe here
        registry.setApplicationDestinationPrefixes("/app"); // Clients send messages here
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/server1")  // WebSocket connection point
                .setAllowedOriginPatterns("*") // Fixes CORS issues
                .withSockJS();  // Enables SockJS fallback
    }
}
