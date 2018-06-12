package com.servegame.bl4de.tag;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

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

  @Inject
  private Logger logger;

  @Listener
  public void onServerStart(GameStartedServerEvent event) {
  }
}
