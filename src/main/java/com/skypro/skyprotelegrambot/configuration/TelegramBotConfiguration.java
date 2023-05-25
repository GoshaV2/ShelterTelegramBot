package com.skypro.skyprotelegrambot.configuration;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class TelegramBotConfiguration {

    @Bean
    public TelegramBot telegramBot(@Value("${telegram.bot.token}") String token) {
        return new TelegramBot(token);
    }

}
