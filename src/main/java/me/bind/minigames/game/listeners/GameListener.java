package me.bind.minigames.game.listeners;

import me.bind.minigames.Minigame;
import me.bind.minigames.game.managers.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GameListener implements Listener {

	private GameManager gameManager;

	public GameListener(Minigame plugin, GameManager gameManager) {
		this.gameManager = gameManager;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if (!gameManager.getBlockManager().canBreak(e.getBlock())) {
			e.setCancelled(true);
		}

		if (gameManager.getBlockManager().canBreak(e.getBlock()) && !e.getPlayer().getItemInHand().equals(new ItemStack(Material.DIAMOND_SPADE))) {
			e.setCancelled(true);
		}

	}

}
