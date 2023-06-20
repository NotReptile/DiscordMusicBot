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
    PlayerManager playerManager = PlayerManager.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(Listeners.class);
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        LOGGER.info("{} is ready", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        Member self = event.getGuild().getSelfMember();
        GuildVoiceState selfVoiceState = self.getVoiceState();
        Member member = event.getMember();
        GuildVoiceState memberVoiceState = member.getVoiceState();
        if (!selfVoiceState.inAudioChannel()) {
            event.getGuild().getAudioManager().openAudioConnection(memberVoiceState.getChannel());
        }
        switch (event.getButton().getId()) {
            case "i1" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=fUDrpLp5gUo");
                event.reply("Added **Mr.Kitty - XIII** to the queue").queue();
            }
            case "i2" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=IjjUQVCvngM");
                event.reply("Added **Mr.Kitty - Rats** to the queue").queue();
            }
            case "i3" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=snuZtrAIb3g");
                event.reply("Added **Mr.Kitty - Hollow** to the queue").queue();
            }
            case "i4" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=MQF4DQz-UEQ");
                event.reply("Added **Mr.Kitty - Devour** to the queue").queue();
            }
            case "i5" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=2hLHfOiFlr8");
                event.reply("Added **Mr.Kitty - Neglect** to the queue").queue();
            }
            case "ad" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=sVx1mJDeUjY");
                event.reply("Added **Mr.Kitty - After Dark** to the queue").queue();
            }
            case "glow" -> {
                playerManager.loadAndPlay(event.getChannel().asTextChannel(), "https://www.youtube.com/watch?v=1TOSiJZX5rw");
                event.reply("Added **Mr.Kitty - Glow** to the queue").queue();
            }
            case "temp" -> event.reply("Why?").queue();
            default -> event.reply("Is it even possible?");
        }

    }
}
