package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;

/**
 * File: CreateGame.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class CreateGame extends AbstractRunnableCommand<CommandSource> {

    public CreateGame(CommandSource src, CommandContext args, TagPlugin plugin) {
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
        return null;
    }
}
