package com.servegame.bl4de.common;

import com.sun.istack.internal.NotNull;

/**
 * File: TagPlugin.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class AbstractTagPlugin implements TagPlugin {

    @NotNull
    protected static AbstractGameManager gameManager;

    @NotNull
    public static TagPlugin instance;

    // protected AbstractCommandManager commandManager;
}
