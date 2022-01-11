package julioapm.stompserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		//Mensagens STOMP cujo cabeçalho de destino iniciem por /game-app são roteadas via @MessageMapping em classe @Controller
		config.setApplicationDestinationPrefixes("/game-app");
		//Endpoint para subscrição e broadcasting
		//Mensagens cujo cabeçalho de destino iniciem por /game-play são encaminhadas diretamente ao broker
		config.enableSimpleBroker("/game-play");
	}
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//Cliente deve se conectar nesse endpoint
		registry.addEndpoint("/game-websocket").setAllowedOrigins("http://localhost:4200").withSockJS();
	}
}
