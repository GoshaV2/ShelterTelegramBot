package com.skypro.skyprotelegrambot.model.command;

public enum UserCommand {
    SEND_CONTACT("/sendContact");
    private final String command;

    UserCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}