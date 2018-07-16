package com.servegame.bl4de.tag;

import com.servegame.bl4de.common.TagPlugin;
import org.spongepowered.api.text.Text;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * File: AbstractCommandManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class AbstractCommandManager {
    private Map<TagPlugin, Set<Text>> usages;

    public AbstractCommandManager() {
        this.usages = new HashMap<>();
    }

    public void registerCommandUsage(TagPlugin plugin, Text commandUsage){
        checkNotNull(plugin, "TagPlugin can't be null!");
        checkNotNull(commandUsage, "Command Usage can't be null!");
        this.usages.computeIfAbsent(plugin, k -> new HashSet<>()).add(commandUsage);
    }

    public List<Text> getCommandUsages(TagPlugin plugin){
        return new ArrayList<>(this.usages.get(plugin));
    }
}
