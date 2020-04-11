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

import java.util.List;

@Service
public class Tbot extends TelegramLongPollingBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tbot.class);

    @Value("${tbot.token}")
    private String botToken;

    @Value("${tbot.name}")
    private String botName;

    public void sendMessage(Message message, String messageText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(messageText);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOGGER.error("Something went wrong! {}", e.getMessage());
        }

    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (update.getMessage() != null ) {
            if (message.getText().equals("Привет")) { ;
                sendMessage(message, "И тебе привет!");
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {

    }

    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }
}
