import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KuraBot extends ListenerAdapter {

    public static void main(String[] args) {
        String token = System.getenv("DISCORD_TOKEN");
        JDA jda = JDABuilder.createDefault(token)
                .setActivity(Activity.listening("Do you wanna build a snowman?"))
                .addEventListeners(new KuraBot())
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String messageSent = event.getMessage().getContentRaw();
        if (!event.getAuthor().isBot()) {
            event.getChannel().sendMessage("This was sent " + messageSent).queue();
        }
    }
}
