package com.tbot.initializer;

import com.tbot.core.Tbot;
import initializer.InitClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Component
public class InitializerClass {

    private static final Logger LOG = LoggerFactory.getLogger(InitClass.class);

    public void init() {
        ApiContextInitializer.init();
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            telegramBotsApi.registerBot(new Tbot());
        } catch (TelegramApiRequestException e) {
            LOG.error("something went wrong {}", e.getMessage());
        }

    }
}
