package com.toxin.telepring.basic;

import com.toxin.telepring.reflection.BotApiMethodController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Execute {

    public static BotApiMethod getExecute(BotApiMethodController controller, Update update) {
        return controller.process(update).get(0);
    }

}
