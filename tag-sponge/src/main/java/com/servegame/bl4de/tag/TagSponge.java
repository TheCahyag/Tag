package com.servegame.bl4de.tag;

import com.google.inject.Inject;
import com.servegame.bl4de.common.AbstractGameManager;
import com.servegame.bl4de.tag.minigame.SpongeGameManager;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;


/**
 * File: TagSponge.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
@Plugin(
        id = Resource.ID,
        name = Resource.NAME,
        description = Resource.DESCRIPTION,
        version = Resource.VERSION,
        url = Resource.URL,
        authors = Resource.AUTHORS
)
public class TagSponge {

    public static Logger logger;
    public static TagSponge instance;
    public static PluginContainer plugin;

    private AbstractGameManager gameManager;

    @Inject
    private Game game;

    @Listener
    public void onConstruction(GameConstructionEvent event){
        instance = this;
        plugin = Sponge.getPluginManager().getPlugin(Resource.ID).get();
        gameManager = new SpongeGameManager(instance);
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        SpongeUtil.registerCommands(Sponge.getCommandManager());
    }


    public AbstractGameManager getGameManager() {
        return gameManager;
    }
}
