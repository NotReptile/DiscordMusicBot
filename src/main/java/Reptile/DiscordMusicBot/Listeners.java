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

        switch (event.getButton().getId()){
            case "i1":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=fUDrpLp5gUo");
            case "i2":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=IjjUQVCvngM");
            case "i3":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=snuZtrAIb3g");
            case "i4":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=MQF4DQz-UEQ");
            case "i5":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=2hLHfOiFlr8");
            case "ad":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=sVx1mJDeUjY");
            case "glow":
                playerManager.loadAndPlay(event.getChannel().asTextChannel(),"https://www.youtube.com/watch?v=1TOSiJZX5rw");
            case "temp":
                event.reply("Кто нажал тот лох :index_pointing_at_the_viewer: ").queue();
            default:
                event.reply("Is it even possible?");
        }

    }
}
