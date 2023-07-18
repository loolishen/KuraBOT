import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.util.Map;

public class KuraBot {

    public static void main(String[] args){
        String token = System.getenv("DISCORD_TOKEN");
        JDA jda = JDABuilder.createDefault(token).build();

    }
}
