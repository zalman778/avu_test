package com.hwx.jms;

import com.hwx.model.Message;
import com.hwx.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;

/*
    Слушатель JMS сообщений
 */
@Component
public class MessageConsumer implements MessageListener {
    @Autowired
    ConsumerRepository consumerRepository;

    @Override
    public void onMessage(javax.jms.Message message) {
        try {
            String xmlMessage = ((TextMessage)message).getText();
            consumerRepository.putMessage(Message.parseXml(xmlMessage));

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
