package Reptile.DiscordMusicBot.buttons;

import Reptile.DiscordMusicBot.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import net.dv8tion.jda.api.utils.messages.MessageEditData;

import java.io.File;
import java.util.List;

public class MusicButtons implements ICommand {
    @Override
    public String getName() {
        return "based";
    }

    @Override
    public String getDescription() {
        return "Buttons for some frequently listened tracks";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }
    File file = new File("src/main/resources/Horosh.png");
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("BASED");
        embedBuilder.setDescription("Choose what to listen");
        embedBuilder.setImage("attachment://Horosh.png");
        Button ad = Button.danger("ad", "AfterDark");
        Button time = Button.danger("time", "TIME");
        Button temp = Button.danger("temp", "IDK");

        MessageEditData message = new MessageEditBuilder()
                .setEmbeds(embedBuilder.build())
                .setFiles(FileUpload.fromData(file, "Horosh.png"))
                .setActionRow(ad,time,temp)
                .build();
        MessageCreateData.fromEditData(message);
        event.reply(MessageCreateData.fromEditData(message)).queue();
    }
}
