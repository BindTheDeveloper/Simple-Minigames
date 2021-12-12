package me.bind.minigames.game.commands;

import me.bind.minigames.Minigame;
import me.bind.minigames.game.GameState;
import me.bind.minigames.utilities.command.BaseCommand;
import me.bind.minigames.utilities.command.Command;
import me.bind.minigames.utilities.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class JoinCommand extends BaseCommand {

    @Command(name = "gamejoin", aliases = {""}, permission = "game.admin")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (!(Minigame.get().getGameManager().getGameState() == GameState.STARTING)) return;
            sendLocation(player);
            player.sendMessage("&eYou have joined the minigame");
            Minigame.get().competitors.add(player.getUniqueId());

    }

    public static void sendLocation(Player player) {
        World w = Bukkit.getServer().getWorld(Minigame.get().getConfig().getString("area.world"));
        double x = Minigame.get().getConfig().getDouble("area.x");
        double y = Minigame.get().getConfig().getDouble("area.y");
        double z = Minigame.get().getConfig().getDouble("area.z");
        player.teleport(new Location(w, x, y, z));
    }
}
