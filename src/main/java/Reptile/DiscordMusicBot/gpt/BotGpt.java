package Reptile.DiscordMusicBot.gpt;

import Reptile.DiscordMusicBot.Config;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotGpt extends ListenerAdapter {
    private final OpenAI openai = new OpenAI(Config.get("OPENAI"));
    private final String channelId = "channel-id";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.isFromGuild()) return;
        if (event.getAuthor().isBot()) return;
        if (event.getAuthor().isSystem()) return;
        Message.suppressContentIntentWarning();
        String message = event.getMessage().getContentRaw();
        if (event.getChannel().getId().equals(channelId)) {
            String response = openai.generateResponse(message);
            System.out.println("Message: " + message);
            System.out.println("Response: " + response);
            if (!message.isEmpty() && !response.isEmpty()){
                event.getChannel().sendMessage(response).queue();
            } else if (!message.isEmpty()){
                event.getChannel().sendMessage("Error getting message from discord").queue();
            }
        }
    }

}
