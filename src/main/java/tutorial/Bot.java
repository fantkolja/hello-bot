package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private String token;
    protected Bot(String token) {
        this.token = token;
    }

    private void logMessageData(Message message) {
        System.out.print("UserId: " + message.getFrom().getId() + "; ");
        System.out.println("MessageText: " + message.getText());
    }
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        User user = msg.getFrom();
        String text = msg.getText();

        logMessageData(msg);

        if (msg.isCommand()) {
            if (text.equals("/start")) {
                sendText(user.getId(), "Привіт, " + user.getFirstName() + "!");
            } else if (text.equals("/say_something")) {
                sendText(user.getId(), "Але шоо ти дууумаєш?..");
            }
        } else {
            sendText(user.getId(), "Але " + text);
        }
    }

    private void sendText(Long userId, String message){
        SendMessage sm = SendMessage.builder()
                .chatId(userId.toString())
                .text(message)
                .build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public String getBotUsername() {
        return "hello_from_zhytomyr_bot";
    }
}
