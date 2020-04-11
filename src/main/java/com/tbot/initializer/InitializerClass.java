package com.tbot.initializer;

import com.tbot.core.Tbot;
import initializer.InitClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@Component
public class InitializerClass {

    @PostConstruct
    public void init() {
        registerTbot();
    }

    private static final Logger LOG = LoggerFactory.getLogger(InitClass.class);

    private final Tbot tbot;

    public InitializerClass(Tbot tbot) {
        this.tbot = tbot;
    }

    public void registerTbot() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(tbot);
        } catch (TelegramApiRequestException e) {
            LOG.error("something went wrong {}", e.getMessage());
        }
    }
}
