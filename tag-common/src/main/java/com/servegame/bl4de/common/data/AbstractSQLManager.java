package com.servegame.bl4de.common.data;

import com.servegame.bl4de.common.TagPlugin;

import java.util.concurrent.ConcurrentHashMap;

/**
 * File: AbstractSQLManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public abstract class AbstractSQLManager implements SQLManager {

    private static ConcurrentHashMap<String, SQLManager> sqlManagers = new ConcurrentHashMap<>();

    private TagPlugin plugin;
    private String database;

    protected AbstractSQLManager(TagPlugin plugin){
        this.plugin = plugin;
        initSettings();
    }

    protected abstract void createTable(String name);



}
