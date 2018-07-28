package com.servegame.bl4de.tag;

import com.servegame.bl4de.common.TagPlugin;
import com.servegame.bl4de.common.command.Descriptions;
import com.servegame.bl4de.common.command.Permissions;
import com.servegame.bl4de.tag.command.AbstractRunnableCommand;
import com.servegame.bl4de.tag.command.CommandGateKeeper;
import com.servegame.bl4de.tag.command.element.SpongeDuration;
import com.servegame.bl4de.tag.command.minigame.*;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.TextActions;

import static org.spongepowered.api.command.args.GenericArguments.*;

/**
 * File: SpongeUtil.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeUtil {

    public final static HoverAction ON_COMMAND_HOVER = TextActions.showText(Text.of("Click to view command parameters"));

    /**
     * Creates a {@link Task.Builder#async()} {@link Task} that executes the action command being ran
     * @param commandInstance instance of a {@link AbstractRunnableCommand}
     * @return {@link CommandResult#success()}
     */
    public static CommandResult executeRunnableCommand(AbstractRunnableCommand commandInstance){
        Task.Builder taskBuilder = Task.builder().async().execute(commandInstance);
        taskBuilder.submit(TagSponge.plugin);
        return CommandResult.success();
    }

    /**
     * TODO
     * @param plugin TODO
     * @param commandManager TODO
     */
    public static void registerCommands(TagPlugin plugin, CommandManager commandManager){

        // /tag create -m# -t#<smh>
        CommandSpec create = CommandSpec.builder()
                .arguments(
                        string(Text.of("game_name")),
                        firstParsing(
                                flags()
                                .valueFlag(integer(Text.of("max_players")), "p")
                                .buildWith(none()),
                                flags()
                                .valueFlag(new SpongeDuration(Text.of("time")), "t")
                                .buildWith(none())
                        )
                )
                .description(Text.of(Descriptions.CREATE_GAME))
                .permission(Permissions.CREATE_GAME)
                .executor((src, args) -> new CreateGame(src, args, plugin).runCommand())
                .build();

        // /tag start <game_name>
        CommandSpec start = CommandSpec.builder()
                .arguments(
                        string(Text.of("game_name"))
                )
                .description(Text.of(Descriptions.START_GAME))
                .permission(Permissions.START_GAME)
                .executor((src, args) -> new StartGame(src, args, plugin).runCommand())
                .build();

        // /tag end <game_name> [-f]
        CommandSpec end = CommandSpec.builder()
                .arguments(
                        string(Text.of("game_name")),
                        optional(flags().flag("f").buildWith(none()))
                )
                .description(Text.of(Descriptions.END_GAME))
                .permission(Permissions.END_GAME)
                .executor((src, args) -> new EndGame(src, args, plugin).runCommand())
                .build();

        // /tag list
        CommandSpec listGames = CommandSpec.builder()
                .description(Text.of(Descriptions.LIST_GAMES))
                .permission(Permissions.LIST_GAMES)
                .executor((src, args) -> new ListGames(src, args, plugin).runCommand())
                .build();

        // /tag help
        CommandSpec help = CommandSpec.builder()
                .description(Text.of(Descriptions.HELP))
                .permission(Permissions.HELP)
                .executor((src, args) -> new Help(src, args, plugin).runCommand())
                .build();

        // /tag ...
        CommandSpec tag = CommandSpec.builder()
                .child(create, "create")
                .child(start, "start")
                .child(end, "end")
                .child(listGames, "list")
                .child(help, "help")
                .arguments(
                        // /tag <game_name> ...
                        string(Text.of("game_name")),
                        optional(
                                firstParsing(
                                        // /tag <game_name> add <player_name>
                                        seq(
                                                literal(Text.of("add"), "add"),
                                                player(Text.of("player_name"))
                                        ),
                                        // /tag <game_name> join [-f]
                                        seq(
                                                literal(Text.of("join"), "join"),
                                                optional(flags().flag("f").buildWith(none()))
                                        )
                                )
                        )
                )
                .executor((src, args) -> new CommandGateKeeper(src, args, plugin).runCommand())
                .build();
        commandManager.register(plugin, tag, "tag");
        registerCommandsInternally();
    }

    private static void registerCommandsInternally(){
        TagPlugin tagSponge = TagSponge.tagSponge;
        new CreateGame(null, null, tagSponge);
        new EndGame(null, null, tagSponge);
        new Help(null, null, tagSponge);
        new ListGames(null, null, tagSponge);
        new StartGame(null, null, tagSponge);
        new StopAllGames(null, null, tagSponge);
        new CommandGateKeeper(null, null, tagSponge);
    }
}
