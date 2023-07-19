package Event;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Calculate extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){

        String[] message = event.getMessage().getContentRaw().split(" ");

        if (message[0].equalsIgnoreCase("!calculate") && message.length == 1){
            event.getChannel().sendMessage("To use !calculate, please add [add/sub] after!").queue();
            event.getChannel().sendMessage("eg: !calculate add 1 2").queue();
        }
        else if (message[0].equalsIgnoreCase("!calculate") && (message[1].equalsIgnoreCase("add"))){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            event.getChannel().sendMessage("The values added up is: " + (num1 + num2)).queue();
        }
        else if (message[0].equalsIgnoreCase("!calculate") && message[1].equalsIgnoreCase("sub")){
            int num1 = Integer.parseInt(message[2]);
            int num2 = Integer.parseInt(message[3]);
            event.getChannel().sendMessage("The values subtracted is: " + (num1 - num2)).queue();
        }

    }
}
