package Reptile.DiscordMusicBot.cmd.commands;

import Reptile.DiscordMusicBot.ICommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class Ping implements ICommand {
    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

    }
}
