import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PeppinoTheBot extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "PeppinoTheBot";
    }
    @Override
    public String getBotToken() {
        return "6614728204:AAFawCJZfAeFfHZ7Yl4aqhPAf-_MuFs1CB0";
    }
    public void onUpdateReceived(Update update) {
        String msg = update.getMessage().getText();
        String chatId=update.getMessage().getChatId().toString();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            // gestione errore in invio
        }
    }
}

