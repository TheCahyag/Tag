package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.AbstractGameManager;
import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.TagSponge;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;

/**
 * File: StopAllGames.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class StopAllGamesCommand extends AbstractRunnableCommand<CommandSource> {

    public StopAllGamesCommand(CommandSource src, CommandContext args, TagPlugin plugin) {
        super(src, args, plugin);
    }

    @Override
    public boolean checkPermission() {
        return true;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        this.hello();
        AbstractGameManager gameManager = TagSponge.tagSponge.getGameManager();
        gameManager.getRunningGames().forEach(miniGame -> {
            miniGame.stop();
            Sponge.getServer().getBroadcastChannel().send(Text.of("Stopping game: " + miniGame));
        });
        return CommandResult.success();
    }

    @Override
    public Text getCommandUsage() {
        return Text.of("/stopall");
    }

    @Override
    public Text getExtendedCommandUsage() {
        return Text.of("Extended command usage");
    }
}
