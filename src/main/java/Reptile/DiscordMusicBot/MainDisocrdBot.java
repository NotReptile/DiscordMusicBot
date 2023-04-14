package Reptile.DiscordMusicBot;

import Reptile.DiscordMusicBot.buttons.MusicButtons;
import Reptile.DiscordMusicBot.cmd.commands.music.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.EnumSet;

public class MainDisocrdBot {
    public static void main(String[] args){
        CommandManager commandManager = new CommandManager();
        //buttons
        commandManager.add(new MusicButtons());
        //music
        commandManager.add(new NowPlaying());
        commandManager.add(new Pause());
        commandManager.add(new Play());
        commandManager.add(new Queue());
        commandManager.add(new Repeat());
        commandManager.add(new Resume());
        commandManager.add(new Skip());
        commandManager.add(new Stop());

        JDABuilder.createDefault(
                        Config.get("token"),
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_VOICE_STATES
                )
                .disableCache(EnumSet.of(
                        CacheFlag.CLIENT_STATUS,
                        CacheFlag.ACTIVITY
                ))
                .enableCache(CacheFlag.VOICE_STATE)
                .addEventListeners(new Listeners())
                .addEventListeners(commandManager)
                .setActivity(Activity.listening("After Dark"))
                .build();
    }
}
