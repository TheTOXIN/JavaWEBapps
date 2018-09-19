package com.toxin.telepring.basic;

import com.toxin.telepring.reflection.BotApiMethodContainer;
import com.toxin.telepring.reflection.BotApiMethodController;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Handle {

    private static final BotApiMethodContainer CONTAINER = BotApiMethodContainer.getInstance();

    public static BotApiMethodController getHandle(Update update) {
        String path;
        BotApiMethodController controller = null;

        if (update.hasMessage() && update.getMessage().hasText()) {
            path = update.getMessage().getText().split(" ")[0].trim();
            controller = CONTAINER.getBotApiMethodController(path);
            if (controller == null) CONTAINER.getBotApiMethodController("");
        } else if (update.hasCallbackQuery()) {
            path = update.getCallbackQuery().getData().split("/")[1].trim();
            controller = CONTAINER.getBotApiMethodController(path);
        }

        return controller;
    }

}
