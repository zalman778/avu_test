package com.hwx.repository;

import com.hwx.model.Message;

import java.util.List;

/*
    Интерфейс репозитория для хранения полученных сообщений.
 */
public interface ConsumerRepository {
    public void putMessage(Message message);
    public List<Message> getMessages();
}
