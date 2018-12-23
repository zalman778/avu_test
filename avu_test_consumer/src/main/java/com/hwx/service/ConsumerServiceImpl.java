package com.hwx.service;

import com.hwx.model.Message;
import com.hwx.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Реализация сервиса
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    @Override
    public List<Message> getMessages() {
        return consumerRepository.getMessages();
    }

    @Override
    public void putMessage(Message message) {
        consumerRepository.putMessage(message);
    }


}
