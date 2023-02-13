package com.example.JRTelegramBot.command;

import com.example.JRTelegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public final static String STOP_MESSEGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execut(Update update) {
        sendBotMessageService.sendMessage(String.valueOf(update.getMessage().getChatId()),STOP_MESSEGE);
    }
}
