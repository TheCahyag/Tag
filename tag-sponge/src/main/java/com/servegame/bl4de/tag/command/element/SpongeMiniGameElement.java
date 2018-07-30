package com.servegame.bl4de.tag.command.element;

import com.servegame.bl4de.tag.minigame.SpongeMiniGame;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;
import java.util.List;

/**
 * File: SpongeMiniGameElement.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeMiniGameElement extends CommandElement {

    private SpongeMiniGame miniGame;

    public SpongeMiniGameElement(@Nullable Text key, SpongeMiniGame miniGame) {
        super(key);
        this.miniGame = miniGame;
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        return null;
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        return null;
    }

    public SpongeMiniGame getMiniGame() {
        return miniGame;
    }
}
