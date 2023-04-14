package Reptile.DiscordMusicBot;

import Reptile.DiscordMusicBot.lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listeners extends ListenerAdapter {
    PlayerManager playerManager = new PlayerManager();

    private static final Logger LOGGER = LoggerFactory.getLogger(Listeners.class);
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        LOGGER.info("{} is ready", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

        if (event.getButton().getId().equals("ad")){
            playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=sVx1mJDeUjY");
        } else if (event.getButton().getId().equals("time")){
            playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=fUDrpLp5gUo&list=PLDb_G8HX8POTRWg-qc6khXKMXAMOd1WLb");
        } else if (event.getButton().getId().equals("temp")){
            event.reply("Testing::temp").queue();
        }
    }
}
