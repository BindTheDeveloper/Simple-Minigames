package me.bind.minigames;

import lombok.Getter;
import me.bind.minigames.game.commands.JoinCommand;
import me.bind.minigames.game.commands.StartCommand;
import me.bind.minigames.game.listeners.GameListener;
import me.bind.minigames.game.managers.GameManager;
import me.bind.minigames.utilities.command.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Minigame extends JavaPlugin {

    private CommandManager commandManager;
    private GameManager gameManager;

    public List<UUID> competitors = new ArrayList<>();

    @Override
    public void onEnable() {
        this.commandManager = new CommandManager(this);
        this.gameManager = new GameManager(this);

        new JoinCommand();
        new StartCommand();
        new GameListener(this, gameManager);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    public static Minigame get() {
        return getPlugin(Minigame.class);
    }
}
