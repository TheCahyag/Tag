package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.AbstractGameManager;
import com.servegame.bl4de.tag.TagSponge;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

/**
 * File: StopAllGames.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class StopAllGames implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        AbstractGameManager gameManager = TagSponge.instance.getGameManager();
        gameManager.getRunningGames().forEach(miniGame -> {
            miniGame.stop();
            Sponge.getServer().getBroadcastChannel().send(Text.of("Stopping game: " + miniGame));
        });
        return CommandResult.success();
    }
}
