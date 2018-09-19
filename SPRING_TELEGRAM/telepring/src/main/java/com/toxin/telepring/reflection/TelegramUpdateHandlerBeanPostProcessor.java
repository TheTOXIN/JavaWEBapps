package com.toxin.telepring.reflection;

import com.toxin.telepring.annotations.BotController;
import com.toxin.telepring.annotations.BotRequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class TelegramUpdateHandlerBeanPostProcessor implements BeanPostProcessor, Ordered {

    public static final Logger log = LoggerFactory.getLogger(TelegramUpdateHandlerBeanPostProcessor.class);

    private BotApiMethodContainer container = BotApiMethodContainer.getInstance();
    private Map<String, Class> botControllerMap = new HashMap<>();

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        if (beanClass.isAnnotationPresent(BotController.class))
            botControllerMap.put(beanName, beanClass);

        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!botControllerMap.containsKey(beanName)) return bean;

        Class original = botControllerMap.get(beanName);

        Method[] methods = original.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BotRequestMapping.class)) {
                generateController(bean, method);
            }
        }

        return bean;
    }

    private void generateController(Object bean, Method method) {
        BotController botController = bean.getClass().getAnnotation(BotController.class);
        BotRequestMapping botRequestMapping = method.getAnnotation(BotRequestMapping.class);

        String path = (botController.value().length != 0 ? botController.value()[0] : "") +
            (botRequestMapping.value().length != 0 ? botRequestMapping.value()[0] : "");

        BotApiMethodController controller = null;

        switch (botRequestMapping.method()[0]) {
            case MSG:
                controller = createControllerUpdate2ApiMethod(bean, method);
                break;
            case EDIT:
                controller = createProcessorListForController(bean, method);
                break;
            default:
                break;
        }

        container.addBotController(path, controller);
    }

    private BotApiMethodController createControllerUpdate2ApiMethod(Object bean, Method method) {
        return new BotApiMethodController(bean, method) {
            @Override
            public boolean successUpdatePredicate(Update update) {
                return update != null &&
                    update.hasMessage() &&
                    update.getMessage().hasText();
            }
        };
    }

    private BotApiMethodController createProcessorListForController(Object bean, Method method) {
        return new BotApiMethodController(bean, method) {
            @Override
            public boolean successUpdatePredicate(Update update) {
                return update != null &&
                    update.hasCallbackQuery() &&
                    update.getCallbackQuery().getData() != null;
            }
        };
    }

    @Override
    public int getOrder() {
        return 100;
    }

}
