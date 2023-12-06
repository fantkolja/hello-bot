package tutorial;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    private static final String tokenKey = "BOT_TOKEN";
    public static void main(String[] args) throws TelegramApiException  {
        String token = System.getenv(tokenKey);
        if (token == null) {
            token = System.getProperty(tokenKey);
        }
        if (token == null) {
            throw new TelegramApiException("Could not find BOT token...");
        }
        launchTelegramBot(token);
    }
    private static void launchTelegramBot(String token) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        botsApi.registerBot(new Bot(token));
    }
}
