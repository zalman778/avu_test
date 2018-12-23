package com.hwx.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

/*
    Отправщик текстовых JMS сообщений
 */
@Component
public class MessageBroker {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String message) {

        jmsTemplate.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                //ObjectMessage objectMessage = session.createObjectMessage(message);
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
    }
}
