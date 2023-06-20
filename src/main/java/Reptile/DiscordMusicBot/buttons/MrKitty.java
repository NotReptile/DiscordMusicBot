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

public class MrKitty implements ICommand {
    @Override
    public String getName() {
        return "kitty";
    }

    @Override
    public String getDescription() {
        return "buttons for MrKitty tracks";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    //File file = new File("src/main/resources/kitty.jpg");

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("MR.KITTY");
        embedBuilder.setDescription("Best mister, but only after Prekol");

        Button xiii = Button.danger("i1", "XIII");
        Button rats = Button.danger("i2", "Rats");
        Button hollow = Button.danger("i3", "Hollow");
        Button devour = Button.danger("i4", "Devour");
        Button neglect = Button.danger("i5", "Neglect");

        MessageEditData message = new MessageEditBuilder()
                .setEmbeds(embedBuilder.build())
                .setActionRow(xiii,rats,hollow,devour,neglect)
                .build();
        MessageCreateData.fromEditData(message);
        event.reply(MessageCreateData.fromEditData(message)).queue();
    }
}
