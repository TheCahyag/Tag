package com.servegame.bl4de.tag;

import com.servegame.bl4de.common.command.Descriptions;
import com.servegame.bl4de.common.command.Permissions;
import com.servegame.bl4de.tag.command.element.SpongeDuration;
import com.servegame.bl4de.tag.command.minigame.CreateGame;
import com.servegame.bl4de.tag.command.minigame.EndGame;
import com.servegame.bl4de.tag.command.minigame.StartGame;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

import static org.spongepowered.api.command.args.GenericArguments.*;

/**
 * File: SpongeUtil.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class SpongeUtil {

    public static void registerCommands(CommandManager commandManager){

        // /tag create -m# -t#<smh>
        CommandSpec create = CommandSpec.builder()
                .arguments(
                        literal(Text.of("create")),
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
                .executor((src, args) -> new CreateGame(src, args).runCommand())
                .build();

        // /tag start <game_name>
        CommandSpec start = CommandSpec.builder()
                .arguments(
                        literal(Text.of("start")),
                        string(Text.of("game_name"))
                )
                .description(Text.of(Descriptions.START_GAME))
                .permission(Permissions.START_GAME)
                .executor((src, args) -> new StartGame(src, args).runCommand())
                .build();

        // /tag end <game_name> [-f]
        CommandSpec end = CommandSpec.builder()
                .arguments(
                        literal(Text.of("end")),
                        string(Text.of("game_name")),
                        optional(flags().flag("f").buildWith(none()))
                )
                .description(Text.of(Descriptions.END_GAME))
                .permission(Permissions.END_GAME)
                .executor((src, args) -> new EndGame(src, args).runCommand())
                .build();

        // /tag list
        CommandSpec listGames = CommandSpec.builder()
                .arguments(
                        literal(Text.of("list"))
                )
                .description(Text.of(Descriptions.LIST_GAMES))
                .permission(Permissions.LIST_GAMES)
                .executor((src, args) -> new EndGame(src, args).runCommand())
                .build();

        // /tag ...
        CommandSpec tag = CommandSpec.builder()
                .child(create, "create")
                .child(start, "start")
                .child(end, "end")
                .child(listGames, "list")
                .arguments(
                        string(Text.of("game_name")),
                        optional(
                                firstParsing(
                                        // /tag <game_name> add
                                        literal(Text.of("add")),
                                        // /tag <game_name> join
                                        literal(Text.of("join"))
                                )
                        )

                )

                .build();
    }
}
