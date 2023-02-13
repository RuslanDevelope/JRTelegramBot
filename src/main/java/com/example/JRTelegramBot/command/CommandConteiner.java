package com.example.JRTelegramBot.command;

import com.example.JRTelegramBot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;
import org.glassfish.jersey.internal.util.collection.ImmutableMultivaluedMap;

public class CommandConteiner {
    private final ImmutableMap immutableMap;
    private Command unknowCommand;

    public CommandConteiner(SendBotMessageService sendBotMessageService) {
        immutableMap = ImmutableMap.<String,Command>builder()
                .put(CommandName.START.getNameCommand(), new StartCommand(sendBotMessageService))
                .put(CommandName.STOP.getNameCommand(), new StopCommand(sendBotMessageService))
                .put(CommandName.HELP.getNameCommand(), new HelpCommand(sendBotMessageService))
                .put(CommandName.NO.getNameCommand(), new NoCommand(sendBotMessageService))
                .build();
        unknowCommand = new UnknowCommand(sendBotMessageService);
    }

    public Command getCommand(String commandIndifirent) {
        return (Command) immutableMap.getOrDefault(commandIndifirent,unknowCommand);
    }
}
