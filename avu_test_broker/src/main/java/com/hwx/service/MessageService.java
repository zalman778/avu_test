package com.hwx.service;

import com.hwx.model.Message;

import javax.xml.bind.JAXBException;

/*
    Интерфейс сервиса сообщений приложения А.
 */
public interface MessageService {
    public String putMessage(Message message);
}
