package Event;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotListeners extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (!event.getAuthor().isBot()){
            String messageSent = event.getMessage().getContentRaw();
            event.getChannel().sendMessage("This was sent: " + messageSent).queue();
        }

    }

    @Override
    public void onChannelCreate(ChannelCreateEvent event) {

        String channelName = event.getChannel().getName();

        TextChannel txtchannel = event.getGuild().getTextChannelById(1118239689204314164L);

        if(txtchannel!= null){
            txtchannel.sendMessage("The channel: \"" + channelName + "\" was added.").queue();
        }
    }
}

