package com.servegame.bl4de.tag.command.minigame;

import com.servegame.bl4de.common.AbstractGameManager;
import com.servegame.bl4de.common.AbstractMiniGame;
import com.servegame.bl4de.common.model.AbstractPlayer;
import com.servegame.bl4de.tag.TagSponge;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import com.servegame.bl4de.tag.model.SpongePlayer;
import com.servegame.bl4de.tag.model.SpongeWorld;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * File: StartGame.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class StartGame extends AbstractRunnableCommand<CommandSource> {

    public StartGame(CommandSource src, CommandContext args) {
        super(src, args);
    }

    @Override
    public boolean checkPermission() {
        return false;
    }

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) {

        List<AbstractPlayer> players = new ArrayList<>();
        Sponge.getServer().getOnlinePlayers().forEach(player -> players.add(new SpongePlayer(player)));
        UUID worldUUID = Sponge.getServer().getDefaultWorld().get().getUniqueId();

        AbstractGameManager gameManager = TagSponge.instance.getGameManager();
        AbstractMiniGame miniGame = gameManager.createMiniGame(players, new SpongeWorld(Sponge.getServer().getWorld(worldUUID).get()));
        gameManager.startMiniGame(miniGame);

        src.sendMessage(Text.of("You started the game"));

        return CommandResult.success();
    }
}