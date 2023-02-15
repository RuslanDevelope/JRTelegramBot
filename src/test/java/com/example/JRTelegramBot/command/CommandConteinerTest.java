package com.example.JRTelegramBot.command;

import com.example.JRTelegramBot.service.SendBotMessageService;
import com.example.JRTelegramBot.service.SendBotMessegeIml;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for CommandContainer")
class CommandConteinerTest {
    private CommandConteiner commandConteiner;

    @Before
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessegeIml.class);
        commandConteiner = new CommandConteiner(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandConteiner.getCommand(commandName.getNameCommand());
                    Assertions.assertNotEquals(UnknowCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/fgjhdfgdfg";

        //when
        Command command = commandConteiner.getCommand(unknownCommand);

        //then
        Assertions.assertEquals(UnknowCommand.class, command.getClass());
    }
}
