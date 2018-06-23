package com.servegame.bl4de.tag.minigame;

import com.servegame.bl4de.common.AbstractMiniGame;
import com.servegame.bl4de.common.AbstractTimer;
import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.World;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;

import java.util.List;

public class SpongeMiniGame extends AbstractMiniGame {

    public SpongeMiniGame(List<AbstractPlayer> activePlayers, World location, AbstractTimer timer) {
        super(activePlayers, location, timer);
    }

    @Override
    protected void preStart() {

    }

    @Override
    protected void postStart() {
        Sponge.getServer().getConsole().sendMessage(Text.of("Let the games begin"));
    }

    @Override
    protected void newTaggedPlayer(AbstractPlayer player) {

    }

    @Override
    protected void preStop() {

    }

    @Override
    protected void postStop() {

    }

    @Override
    protected void preCreation() {

    }

    @Override
    protected void postCreation() {

    }

    @Override
    protected void printStats() {
        Sponge.getServer().getBroadcastChannel().send(Text.of("The game took: " + this.getTotalGameTime().toString()));
    }
}
