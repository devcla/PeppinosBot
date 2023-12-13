public class Main {
    public static void main(String[] args) {
        /*try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new PeppinoTheBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/
        PeppinosCrawler peppinosCrawler = new PeppinosCrawler();
        peppinosCrawler.crawl();
    }
}
