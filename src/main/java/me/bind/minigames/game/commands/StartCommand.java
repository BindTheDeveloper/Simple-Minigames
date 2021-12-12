package me.bind.minigames.game.commands;

import me.bind.minigames.Minigame;
import me.bind.minigames.game.GameState;
import me.bind.minigames.utilities.command.BaseCommand;
import me.bind.minigames.utilities.command.Command;
import me.bind.minigames.utilities.command.CommandArgs;

public class StartCommand extends BaseCommand {

	@Command(name = "gamestart", aliases = {""}, permission = "game.admin")
	@Override
	public void onCommand(CommandArgs command) {
		Minigame.get().getGameManager().setGameState(GameState.STARTING);
	}
}
