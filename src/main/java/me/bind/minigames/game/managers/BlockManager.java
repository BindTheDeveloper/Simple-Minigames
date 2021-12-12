package me.bind.minigames.game.managers;

import org.bukkit.Material;
import org.bukkit.block.Block;
import java.util.HashSet;
import java.util.Set;

public class BlockManager {

    private Set<Material> allowedToBreak = new HashSet<>();
    private GameManager gameManager;

    public BlockManager(GameManager gameManager) {
        this.gameManager = gameManager;

        allowedToBreak.add(Material.SNOW_BLOCK);
    }


    public boolean canBreak(Block block) { return allowedToBreak.contains(block.getType()); }
}
