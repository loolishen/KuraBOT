import Event.BotListeners;
import Event.Calculate;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;


public class KuraBot extends ListenerAdapter {

    public static void main(String[] args) throws InterruptedException {
        String token = System.getenv("DISCORD_TOKEN");
        JDA jda = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new BotListeners())
                .addEventListeners(new Calculate())
                .build();
    }

}
