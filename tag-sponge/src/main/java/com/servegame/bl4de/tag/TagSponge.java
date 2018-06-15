package com.servegame.bl4de.tag;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

@Plugin(
        id = "tag",
        name = "Tag",
        description = "A Simple Tag Game for Minecraft",
        url = "https://github.com/TheCahyag/Tag",
        authors = {
                "TheCahyag"
        }
)
public class TagSponge {

    public static Logger logger;
    public static TagSponge instance;
    public static PluginContainer plugin;

    @Inject
    private Game game;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        game.getServer().getConsole().sendMessage(Text.of("Hello world from plugin"));
    }
}
