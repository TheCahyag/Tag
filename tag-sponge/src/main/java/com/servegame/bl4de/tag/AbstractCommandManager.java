package com.servegame.bl4de.tag;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.command.AbstractCommand;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * File: AbstractCommandManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class AbstractCommandManager {
    private Map<TagPlugin, AbstractCommand> mappings;

    public AbstractCommandManager() {
        this.mappings = new HashMap<>();
    }

    public void registerCommand(TagPlugin plugin, AbstractCommand command){
        checkNotNull(plugin, "TagPlugin can't be null!");
        checkNotNull(command, "Command can't be null!");
        this.mappings.put(plugin, command);
    }
}
