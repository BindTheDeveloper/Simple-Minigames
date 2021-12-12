package me.bind.minigames.game.managers;


import me.bind.minigames.Minigame;
import me.bind.minigames.game.GameState;
import me.bind.minigames.tasks.GameStartCountdownTask;
import org.bukkit.entity.Player;

public class GameManager {
	
	private final Minigame plugin;
	public GameState gameState = GameState.LOBBY;

	private final BlockManager blockManager;
	private final PlayerManager playerManager;

	private GameStartCountdownTask gameStartCountdownTask;

	public GameManager(Minigame plugin) {
		this.plugin = plugin;

		this.blockManager = new BlockManager(this);
		this.playerManager = new PlayerManager(this);
	}

	public void setGameState(GameState gameState) {
		if (this.gameState == GameState.ACTIVE && gameState == GameState.STARTING) return;
		if (this.gameState == gameState) return;

		this.gameState = gameState;

		switch (gameState) {
			case ACTIVE:
				if (this.gameStartCountdownTask != null) this.gameStartCountdownTask.cancel();

				getPlayerManager().giveKits();
				break;
			case STARTING:

				this.gameStartCountdownTask = new GameStartCountdownTask(this);
				this.gameStartCountdownTask.runTaskTimer(plugin, 0, 20);
				break;
		}
	}

	public GameState getGameState() {
		return gameState;
	}

	public BlockManager getBlockManager() {
		return blockManager;
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}
}
