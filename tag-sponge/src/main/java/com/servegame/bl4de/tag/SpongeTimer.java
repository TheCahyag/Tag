package com.servegame.bl4de.tag;

import com.servegame.bl4de.common.AbstractTimer;
import org.spongepowered.api.text.Text;

/**
 * File: SpongeTimer.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeTimer extends AbstractTimer {

    public SpongeTimer() {
        super();
    }

    @Override
    public Text durationToText() {
        return Text.of(this.getDurationInSeconds(), " seconds long (from SpongeTimer.java)\n");
    }
}
