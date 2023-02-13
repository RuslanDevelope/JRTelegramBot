package com.example.JRTelegramBot.command;

public enum CommandName {
    START("start"),
    STOP("stop"),
    HELP("help"),
    NO("no");

    private final String name;

    CommandName(String name) {
    this.name = name;
    }

    public String getNameCommand(){
        return  name;
    }
}
