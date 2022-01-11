package julioapm.stompserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GameController {
	private final SimpMessagingTemplate template;
	
	@Autowired
	public GameController(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	//Envio de mensagens diretamente para /game-app/play-card
	@MessageMapping("/play-card")
	@SendTo("/game-play/game-update")
	public PlayResponseMessage playCard(PlayMessage message) throws Exception {
		Thread.sleep(1000); //simulando um processamento demorado
		return new PlayResponseMessage(message.getPlayer(), "A card was played");
	}
	
	//Envio de requisição HTTP para /game-controller/finish
	@GetMapping("/game-controller/finish")
	public String gameOver() throws Exception {
		this.template.convertAndSend("/game-play/game-update", "Game over man!");
		return "Finished";
	}
}
