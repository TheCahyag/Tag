package com.servegame.bl4de.common.data;

import java.sql.Connection;

/**
 * File: SQLManager.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public interface SQLManager {

    void initSettings();

    Connection getConnection();

    boolean testConnection();




}
