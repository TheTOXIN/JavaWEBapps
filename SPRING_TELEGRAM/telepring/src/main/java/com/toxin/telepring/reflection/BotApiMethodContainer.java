package com.toxin.telepring.reflection;

import com.toxin.telepring.exception.BotApiMethodContainerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class BotApiMethodContainer {

    private final Logger log = LoggerFactory.getLogger(BotApiMethodContainer.class);

    private Map<String, BotApiMethodController> controllerMap;

    public static BotApiMethodContainer getInstance() {
        return Holder.INST;
    }

    public void addBotController(String path, BotApiMethodController controller) {
        if (controllerMap.containsKey(path))
            throw new BotApiMethodContainerException("Path: " + path + " already added");
        log.trace("Add telegram bot controller for PATH: {}", path);
        this.controllerMap.put(path, controller);
    }

    public BotApiMethodController getBotApiMethodController(String path) {
        return this.controllerMap.get(path);
    }

    private BotApiMethodContainer() {
        this.controllerMap = new HashMap<>();
    }

    private static class Holder {
        private static final BotApiMethodContainer INST = new BotApiMethodContainer();
    }

}
