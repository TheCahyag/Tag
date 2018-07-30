package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.TagSponge;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import com.servegame.bl4de.tag.command.Command;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;

import java.util.List;

import static com.servegame.bl4de.tag.SpongeUtil.*;
import static org.spongepowered.api.text.format.TextColors.*;

/**
 * File: Help.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class HelpCommand extends AbstractRunnableCommand<CommandSource> {

    public HelpCommand(CommandSource src, CommandContext args, TagPlugin plugin) {
        super(src, args, plugin);
    }

    @Override
    public boolean checkPermission() {
        return true;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        List<Command> commandUsages = TagSponge.tagSponge.getTagCommandManager().getCommands(TagSponge.instance);
        Text message = Text.of(RED, "---------------------------------------\n");
        for (Command command :
                commandUsages) {
            message = message.toBuilder()
                    .append(Text.builder()
                            .append(command.getCommandUsage(), Text.of("\n"))
                            .onHover(ON_COMMAND_HOVER)
                            .onClick(TextActions.executeCallback(commandSource -> command.getExtendedCommandUsage()))
                            .build())
                    .build();
        }
        message = message.toBuilder().append(Text.of(DARK_RED, "---------------------------------------")).build();
        src.sendMessage(message);
        return CommandResult.success();
    }

    @Override
    public Text getCommandUsage() {
        return Text.of("/help");
    }

    @Override
    public Text getExtendedCommandUsage() {
        return Text.of("extended command usage");
    }
}
