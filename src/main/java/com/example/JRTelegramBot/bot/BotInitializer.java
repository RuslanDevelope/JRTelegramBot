package com.example.JRTelegramBot.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInitializer {
    @Autowired
    JRTelegramBot jrTelegramBot;
@EventListener({ContextRefreshedEvent.class})
    public void initBot() {
        try {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(jrTelegramBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
