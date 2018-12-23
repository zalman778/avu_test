package com.hwx.service;

import com.hwx.jms.MessageBroker;
import com.hwx.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.Date;
import java.util.UUID;

/*
    Реализация сервиса отправки сообщений.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageBroker messageBroker;

    @Override
    public String putMessage(Message message)  {
        try {
            message.setUid(UUID.randomUUID().toString());
            message.setCreateDate(new Date());
            String xmlMessageString = Message.toXml(message);
            messageBroker.sendMessage(xmlMessageString);
            return "OK";
        } catch (JAXBException e) {
            return "ERR";
        }
    }
}
