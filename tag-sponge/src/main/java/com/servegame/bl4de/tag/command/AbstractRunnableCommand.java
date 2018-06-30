package com.servegame.bl4de.tag.command;

import com.servegame.bl4de.common.TagPlugin;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;

/**
 * File: AbstractRunnableCommand.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public abstract class AbstractRunnableCommand<T extends CommandSource> extends AbstractCommand<T> implements Runnable {

    public AbstractRunnableCommand(T src, CommandContext args, TagPlugin plugin){
        super(src, args, plugin);
    }

    @Override
    public void run(){
        runCommand();
    }

}
