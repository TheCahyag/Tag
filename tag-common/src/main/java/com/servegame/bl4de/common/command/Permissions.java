package com.servegame.bl4de.common.command;

/**
 * File: Permissions.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public final class Permissions {

    // All permissions
    private static final String TAG_PRE = "tag.";

    // Base permissions
    private static final String BASE_PRE = TAG_PRE + "base.";

    public static final String ADD_PLAYER_TO_GAME = BASE_PRE + "addplayer";
    public static final String JOIN_GAME = BASE_PRE + "join";
    public static final String LIST_GAMES = BASE_PRE + "list";
    public static final String LIST_GAME_INFO = BASE_PRE + "info";

    // Action permissions
    private static final String ACTION_PRE = TAG_PRE + "action.";

    public static final String CREATE_GAME = ACTION_PRE + "create";
    public static final String START_GAME = ACTION_PRE + "start";
    public static final String END_GAME = ACTION_PRE + "stop";

    public static final String HELP = TAG_PRE + "help";
}
