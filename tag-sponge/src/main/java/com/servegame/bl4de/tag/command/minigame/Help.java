package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.TagSponge;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.Text;

import java.util.List;

/**
 * File: Help.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class Help extends AbstractRunnableCommand<CommandSource> {

    public Help(CommandSource src, CommandContext args, TagPlugin plugin) {
        super(src, args, plugin);
    }

    @Override
    public boolean checkPermission() {
        return true;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {
        List<Text> commandUsages = TagSponge.tagSponge.getTagCommandManager().getCommandUsages(TagSponge.instance);
        Text message = Text.of("-----------------------------\n");
        for (Text text :
                commandUsages) {
            message = message.toBuilder().append(text, Text.of("\n")).build();
        }
        message = message.toBuilder().append(Text.of("--------------------------------")).build();
        src.sendMessage(message);
        hello();
        return CommandResult.success();
    }

    @Override
    public Text getCommandUsage() {
        return Text.of("/help");
    }
}
