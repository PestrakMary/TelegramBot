package pestrak.mary.telegram.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import pestrak.mary.telegram.bot.service.CityService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class GuideBot extends TelegramLongPollingBot {

    static Map<String, String> commands;

    @Autowired
    CityService cityService;

    static {
        ApiContextInitializer.init();

        commands = new HashMap<String, String>(){
            @Override
            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                forEach((s, s2) -> {
                    stringBuffer.append(s);
                    stringBuffer.append(" - ");
                    stringBuffer.append(s2);
                    stringBuffer.append('\n');
                });
                return stringBuffer.toString();
            }
        };
        commands.put("/start", "Привет, путешественник!");
        commands.put("/getguide", "Подскажу, куда пойти, только город ты введи)");
        commands.put("/help", commands.toString());
    }

    @PostConstruct
    public void registerBot() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    void sendMessage (Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message != null && message.hasText()) {
            String[] args = message.getText().split(" ");
            if (args.length == 1) {
                sendMessage(message, commands.get(args[0]));
            } else {
                sendMessage(message, cityService.findInformationByCity(args[1]));
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "guide_bot";
    }

    @Override
    public String getBotToken() {
        return "1291598720:AAEDgB-q0zb6yQp_H6xi9B3TLIGKnSPYAHU";
    }
}
