package me.bind.minigames.tasks;

import me.bind.minigames.Minigame;
import me.bind.minigames.game.GameState;
import me.bind.minigames.game.managers.GameManager;
import me.bind.minigames.utilities.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdownTask extends BukkitRunnable {

    private GameManager gameManager;

    public GameStartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private int timeLeft = Minigame.get().getConfig().getInt("countdown-seconds");

    @Override
    public void run() {
        timeLeft--;
        if (timeLeft <= 0) {
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
            return;
        }

        Bukkit.broadcastMessage(ChatUtil.translate("&aGame will commence in " + timeLeft + " seconds do /gameJoin to participate"));
    }
}
