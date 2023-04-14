package Reptile.DiscordMusicBot.cmd.commands.music;

import Reptile.DiscordMusicBot.ICommand;
import Reptile.DiscordMusicBot.lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Play implements ICommand {

    @Override
    public String getName() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "play a song";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> optionDataList = new ArrayList<>();
        optionDataList.add(new OptionData(OptionType.STRING,"link", "Name of the song or URL", true));
        return optionDataList;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        GuildVoiceState memberVoiceState = member.getVoiceState();

        if(!memberVoiceState.inAudioChannel()) {
            event.reply("You need to be in a voice channel").queue();
            return;
        }

        Member self = event.getGuild().getSelfMember();
        GuildVoiceState selfVoiceState = self.getVoiceState();

        if(!selfVoiceState.inAudioChannel()) {
            event.getGuild().getAudioManager().openAudioConnection(memberVoiceState.getChannel());
        } else {
            if(selfVoiceState.getChannel() != memberVoiceState.getChannel()) {
                event.reply("You need to be in the same channel as me").queue();
                return;
            }
        }

        String link = event.getOption("link").getAsString();
        if (!isUrl(link)){
            link = "ytsearch:" + link + " audio";
        }
        PlayerManager playerManager = PlayerManager.getInstance();
        if (isUrl(link))
            playerManager.loadAndPlay(event.getChannel().asTextChannel(),link);
        else
            playerManager.loadAndPlay(event.getChannel().asTextChannel(),link);

    }
    private boolean isUrl(String input) {
        try {
            new URI(input);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
