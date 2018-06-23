package com.servegame.bl4de.tag.model;


import com.servegame.bl4de.common.model.AbstractWorld;
import org.spongepowered.api.world.World;

import java.util.UUID;

public class SpongeWorld extends AbstractWorld {

    private World world;

    public SpongeWorld(org.spongepowered.api.world.World world){
        this.world = world;
    }

    @Override
    public String getName() {
        return this.world.getName();
    }

    @Override
    public UUID getUUID() {
        return this.world.getUniqueId();
    }
}
