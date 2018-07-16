package com.servegame.bl4de.tag.command;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.TagSponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

/**
 * File: AbstractCommand.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public abstract class AbstractCommand<T extends CommandSource> implements CommandExecutor {

    protected T src;
    protected CommandContext args;

    public AbstractCommand(T src, CommandContext args, TagPlugin plugin) {
        this.src = src;
        this.args = args;
        TagSponge.tagSponge.getTagCommandManager().registerCommandUsage(plugin, this.getCommandUsage());
    }

    /**
     * TODO
     * @return TODO
     */
    public CommandResult runCommand(){
        if (!this.checkPermission()){
            System.out.println("user doesn't have permission");
            return CommandResult.empty();
        }
        return execute(this.src, this.args);
    }

    /**
     * Checks to see if the {@link CommandSource} has permission to run the current command
     * @return true if the src has permission false otherwise
     */
    public abstract boolean checkPermission();

    @Override
    public abstract CommandResult execute(CommandSource src, CommandContext args);

    /**
     * TODO
     * @return TODO
     */
    public abstract Text getCommandUsage();

    // Temp

    public void hello(){
        this.src.sendMessage(Text.of("Hello from: " + this.getClass()));
    }
}
