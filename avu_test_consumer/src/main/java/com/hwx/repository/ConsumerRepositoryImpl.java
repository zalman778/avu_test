package com.hwx.repository;

import com.hwx.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    Реализация репозитория
 */
@Service("messageRepository")
public class ConsumerRepositoryImpl implements ConsumerRepository {
    private final List<Message> messages = new CopyOnWriteArrayList<Message>();

    @Override
    public void putMessage(Message message) {
        messages.add(0, message);
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }
}
