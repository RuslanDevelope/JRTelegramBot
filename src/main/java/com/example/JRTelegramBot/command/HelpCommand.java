package com.example.JRTelegramBot.command;

import com.example.JRTelegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"

                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n",
            CommandName.START.getNameCommand(), CommandName.STOP.getNameCommand(), CommandName.HELP.getNameCommand());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execut(Update update) {
        sendBotMessageService.sendMessage(String.valueOf(update.getMessage().getChatId()),HELP_MESSAGE);
    }
}
