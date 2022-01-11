package julioapm.stompserver;

public class PlayMessage {
	private String player;

	public PlayMessage() {
		
	}
	
	public PlayMessage(String player) {
		this.player = player;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
}
