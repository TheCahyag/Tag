package com.servegame.bl4de.tag.command.element;

import com.servegame.bl4de.common.command.element.Duration;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;
import java.util.List;

/**
 * File: SpongeDuration.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeDuration extends CommandElement implements Duration {

    private Long seconds;

    public SpongeDuration(@Nullable Text key) {
        super(key);
        this.seconds = 0L;
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {

        System.out.println(args);
        return this.seconds;
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        return null;
    }

    @Override
    public Long getSeconds() {
        return this.seconds;
    }
}
