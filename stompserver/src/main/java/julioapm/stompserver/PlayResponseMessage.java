package julioapm.stompserver;

public class PlayResponseMessage {
	private String lastPlayer;
	private String content;

	public PlayResponseMessage() {
		
	}
	
	public PlayResponseMessage(String lastPlayer, String content) {
		this.lastPlayer = lastPlayer;
		this.content = content;
	}

	public String getLastPlayer() {
		return lastPlayer;
	}

	public String getContent() {
		return content;
	}
	
	
}
