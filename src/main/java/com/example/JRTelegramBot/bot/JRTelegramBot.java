package com.example.JRTelegramBot.bot;

import com.example.JRTelegramBot.command.CommandConteiner;
import com.example.JRTelegramBot.command.CommandName;
import com.example.JRTelegramBot.service.SendBotMessegeIml;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class JRTelegramBot extends TelegramLongPollingBot {
    final BotConfig botConfig;
    private CommandConteiner commandConteiner;
    private final String COMMAND_PREFIX = "/";

    public JRTelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
        commandConteiner = new CommandConteiner(new SendBotMessegeIml(this));
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messege = update.getMessage().getText().toLowerCase();
            if (messege.startsWith(COMMAND_PREFIX)) {
                commandConteiner.getCommand(splitMessege(messege)).execut(update);
            } else {
                commandConteiner.getCommand(CommandName.NO.getNameCommand()).execut(update);
            }
        }
    }

    private String splitMessege(String messege) {
        return messege.split(COMMAND_PREFIX)[1];
    }
}
