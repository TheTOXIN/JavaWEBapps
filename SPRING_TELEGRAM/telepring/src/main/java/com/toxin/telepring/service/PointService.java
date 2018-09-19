package com.toxin.telepring.service;

import com.toxin.telepring.dao.PointDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class PointService {

    private final PointDAO pointDAO;

    @Autowired
    public PointService(PointDAO pointDAO) {
        this.pointDAO = pointDAO;
    }

    public SendMessage testPoint(Update update) {
        return new SendMessage()
            .setChatId(update.getMessage().getChatId().toString())
            .setText(pointDAO.testPoint());
    }

}
