import org.openqa.selenium.support.ui.ISelect;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
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
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String text = message.getText();

            if (text.startsWith("/classifica")) {
                String[] commandParts = text.split("\\s+");

                if (commandParts.length >= 3) {
                    String anno = commandParts[1];
                    String categoria = commandParts[2];
                    PeppinosDatabase db = new PeppinosDatabase();
                    String result = db.select(anno, categoria);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(result);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

