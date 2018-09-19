package com.toxin.telepring.basic;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

//    public Bot(DefaultBotOptions options) {
//        super(options);
//    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(Execute.getExecute(Handle.getHandle(update), update));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return Config.TOKEN;
    }

    @Override
    public String getBotUsername() {
        return Config.NAME;
    }

}
