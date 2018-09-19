package com.toxin.telepring.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public abstract class BotApiMethodController {

    private final Logger log = LoggerFactory.getLogger(BotApiMethodController.class);

    private Object bean;
    private Method method;
    private Process processUpdate;

    public BotApiMethodController(Object bean, Method method) {
        this.bean = bean;
        this.method = method;

        this.processUpdate = typeListReturnDetect() ? this::processList : this::processSingle;
    }

    public abstract boolean successUpdatePredicate(Update update);

    public List<BotApiMethod> process(Update update) {
        if (successUpdatePredicate(update)) return null;

        try {
            return this.processUpdate.accept(update);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("BAD invoke METHOD", e);
        }

        return null;
    }

    private boolean typeListReturnDetect() {
        return List.class.equals(this.method.getReturnType());
    }

    private List<BotApiMethod> processSingle(Update update)
        throws InvocationTargetException, IllegalAccessException {
        BotApiMethod botApiMethod = (BotApiMethod) method.invoke(bean, update);
        return botApiMethod != null ? Collections.singletonList(botApiMethod) : Collections.emptyList();
    }

    private List<BotApiMethod> processList(Update update)
        throws InvocationTargetException, IllegalAccessException {
        List<BotApiMethod> botApiMethods = (List<BotApiMethod>) method.invoke(bean, update);
        return botApiMethods != null ? botApiMethods : Collections.emptyList();
    }

    private interface Process {
        List<BotApiMethod> accept(Update update) throws InvocationTargetException, IllegalAccessException;
    }

}
