package com.toxin.telepring;

import com.toxin.telepring.basic.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class TelepringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelepringApplication.class, args);
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();
        Bot bot = new Bot();

        try {
            botsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}
