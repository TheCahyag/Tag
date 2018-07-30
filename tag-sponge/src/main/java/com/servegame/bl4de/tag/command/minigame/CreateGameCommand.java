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
public class CreateGameCommand extends AbstractRunnableCommand<CommandSource> {

    public CreateGameCommand(CommandSource src, CommandContext args, TagPlugin plugin) {
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
        return Text.of("/create");
    }

    @Override
    public Text getExtendedCommandUsage() {
        return Text.builder()
                .append(this.getCommandUsage(), Text.of("\n"))
                .append(Text.of("DESCRIPTION\n"))
                .append(Text.of("  Create a game of tag\n"))
                .append(Text.of("PARAMETERS\n"))
                .append(Text.of("  REQUIRED\n"))
                .append(Text.of("    <game_name>: Name for the mini game\n"))
                .append(Text.of("  OPTIONAL\n"))
                .append(Text.of("    -s#: Maximum number of players\n"))
                .append(Text.of("    -t#<s|m|h>: Max time for game\n"))
                .append(Text.of("---------------------------------------\n"))
                .build();
    }
}
