package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;

/**
 * File: GameInfoCommand.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class GameInfoCommand extends AbstractRunnableCommand<CommandSource> {

    public GameInfoCommand(CommandSource src, CommandContext args, TagPlugin plugin) {
        super(src, args, plugin);
    }

    @Override
    public boolean checkPermission() {
        return false;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        return null;
    }

    @Override
    public Text getCommandUsage() {
        return null;
    }

    @Override
    public Text getExtendedCommandUsage() {
        return null;
    }
}
