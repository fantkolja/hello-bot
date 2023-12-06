package tutorial;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotToken() {
        return "4839574812:AAFD39kkdpWt3ywyRZergyOLMaJhac60qc";
    }

    @Override
    public String getBotUsername() {
        return "hello_from_zhytomyr_bot";
    }
}
