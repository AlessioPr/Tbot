package com.tbot.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class Tbot extends TelegramLongPollingBot {

    @Value("${tbot.name}")
    private String botName;

    @Value("${tbot.token}")
    private String botToken;

    private static final Logger LOG = LoggerFactory.getLogger(Tbot.class);

    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        if (message != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText("Привет, Юлиана!");
            try {
                execute(sendMessage); // Sending our message object to user
            } catch (TelegramApiException e) {
                LOG.error("Something went wrong! {}", e.getMessage());
            }
        }
    }

    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }
}
