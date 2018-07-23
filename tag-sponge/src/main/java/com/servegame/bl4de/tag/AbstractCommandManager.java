package com.servegame.bl4de.tag;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.tag.command.Command;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * File: AbstractCommandManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class AbstractCommandManager {
    private Map<TagPlugin, Set<Command>> usages;

    public AbstractCommandManager() {
        this.usages = new HashMap<>();
    }

    public void registerCommandUsage(TagPlugin plugin, Command command){
        checkNotNull(plugin, "TagPlugin can't be null!");
        this.usages.computeIfAbsent(plugin, k -> new HashSet<>()).add(command);
    }

    public List<Command> getCommands(TagPlugin plugin){
        return new ArrayList<>(this.usages.get(plugin));
    }
}
