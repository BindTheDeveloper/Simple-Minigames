package me.bind.minigames.game.managers;

import me.bind.minigames.Minigame;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {

    private GameManager gameManager;

    public PlayerManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void giveKits() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::giveKit);
    }

    public void giveKit(Player player) {
        if (!Minigame.get().competitors.contains(player.getUniqueId())) return;
        player.getInventory().addItem(new ItemStack(Material.DIAMOND_SPADE));
    }
}
