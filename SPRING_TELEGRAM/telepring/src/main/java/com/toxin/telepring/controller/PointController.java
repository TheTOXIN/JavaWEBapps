package com.toxin.telepring.controller;

import com.toxin.telepring.annotations.BotController;
import com.toxin.telepring.annotations.BotRequestMapping;
import com.toxin.telepring.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@BotController
public class PointController {

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @BotRequestMapping("/point")
    public SendMessage testPoint(Update update) {
        return pointService.testPoint(update);
    }

}
