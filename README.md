TAG DEL BOT: @Pennarellos_bot


Prima di tutto bisogna popolare il database, quindi bisogna:
  1. aprire xampp
  2. startare mysql
  3. aprire la console
  4. scrivere il comando: mysql -u root -p
  5. premere invio alla richiesta della password
  6. e poi scrivere: source 'qui inserire percorso del file creazioneDatabase.sql'
  7. aprire il progetto e aprire il Main.java la funzione main deve essere:
```
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new PeppinosCrawler());
        executorService.shutdown();
    }
}
```
ATTENZIONE
il processo di popolazione durera' circa 1 ora e mezza.

Dopo aver popolato il database una volta non serve piu popolarlo fino all'uscita delle nuove classifiche.

Per eseguire il programma in modo da usare il bot su telegram, il main deve essere:
```
public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new PeppinoTheBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
```
Il bot, inserito il comando /classifica 'anno' 'categoria' in caso nel database sia presente la classifica richiesta la stampa in un messaggio telegram.

