package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;

/**
 * File: ListGames.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class ListGamesCommand extends AbstractRunnableCommand<CommandSource> {

    public ListGamesCommand(CommandSource src, CommandContext args, TagPlugin plugin) {
        super(src, args, plugin);
    }

    @Override
    public boolean checkPermission() {
        return true;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        this.hello();
        return CommandResult.success();
    }

    @Override
    public Text getCommandUsage() {
        return Text.of("/list");
    }

    @Override
    public Text getExtendedCommandUsage() {
        return Text.of("Extended command usage");
    }
}
