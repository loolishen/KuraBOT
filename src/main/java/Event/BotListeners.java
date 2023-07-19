package Event;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class BotListeners extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getChannel().asTextChannel().getName(), Objects.requireNonNull(event.getMember()).getEffectiveName(),
                    event.getMessage().getContentDisplay());
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

