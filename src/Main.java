import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new PeppinoTheBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        /*
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new PeppinosCrawler());
        executorService.shutdown();*/
    }
}
