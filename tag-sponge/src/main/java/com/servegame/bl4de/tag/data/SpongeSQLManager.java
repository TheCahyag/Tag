package com.servegame.bl4de.tag.data;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.common.data.AbstractSQLManager;

import java.sql.Connection;

/**
 * File: SpongeSQLManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeSQLManager extends AbstractSQLManager {

    public SpongeSQLManager(TagPlugin plugin) {
        super(plugin);
    }

    @Override
    protected void createTable(String name) {

    }

    @Override
    public void initSettings() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public boolean testConnection() {
        return false;
    }
}
