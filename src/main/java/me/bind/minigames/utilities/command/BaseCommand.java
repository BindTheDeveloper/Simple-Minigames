package me.bind.minigames.utilities.command;


import me.bind.minigames.Minigame;

public abstract class BaseCommand {

    public BaseCommand() {
        Minigame.get().getCommandManager().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);
}
