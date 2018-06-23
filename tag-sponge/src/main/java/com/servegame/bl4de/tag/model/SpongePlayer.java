package com.servegame.bl4de.tag.model;


import com.flowpowered.math.vector.Vector3d;
import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.common.model.location.Vector3D;
import org.spongepowered.api.entity.living.player.Player;

import java.util.UUID;

public class SpongePlayer extends AbstractPlayer {

    private final Player player;

    public SpongePlayer(Player player){
        this.player = player;
    }

    @Override
    public Vector3D getPosition() {
        Vector3d vector = this.player.getLocation().getPosition();
        return new Vector3D(vector.getX(), vector.getY(), vector.getZ());
    }

    @Override
    public String getName() {
        return this.player.getName();
    }

    @Override
    public UUID getUUID() {
        return this.player.getUniqueId();
    }
}
