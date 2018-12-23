package com.hwx.service;

import com.hwx.model.Message;

import java.util.List;

/*
    Интерфейс сервиса для просмотра сообщений
 */
public interface ConsumerService {
    public List<Message> getMessages();
}
