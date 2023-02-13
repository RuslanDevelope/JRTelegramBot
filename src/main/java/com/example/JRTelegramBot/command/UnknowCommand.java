package com.example.JRTelegramBot.command;

import com.example.JRTelegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknowCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    public UnknowCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execut(Update update) {
        sendBotMessageService.sendMessage(String.valueOf(update.getMessage().getChatId()),UNKNOWN_MESSAGE);
    }
}
