package com.hwx.service;

import com.hwx.model.Message;
import com.hwx.repository.ConsumerRepositoryImpl;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ConsumerServiceImplTest {

    @Mock
    ConsumerRepositoryImpl consumerRepository;

    @InjectMocks
    ConsumerServiceImpl consumerService;

    @Captor
    ArgumentCaptor<Message> captor;

    @Spy
    List<Message> messages = new ArrayList<Message>();

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        messages = getMessages();
    }

    public List<Message> getMessages() {
        Message message = new Message();
        message.setIntValue(1);
        message.setCreateDate(new Date());
        message.setDateValue(new Date());
        message.setPickValue(1);
        message.setUid("uid");

        messages.add(message);
        return messages;
    }

    /*
     * Scenario for message insert
     */

    @Test
    public void succesfullPutMessage() {
        doNothing().when(consumerRepository).putMessage(any(Message.class));
        consumerRepository.putMessage(messages.get(0));

        verify(consumerRepository, times(1)).putMessage(captor.capture());

        Assert.assertEquals(captor.getValue().getUid(), "uid");

        Assert.assertEquals(2, messages.size());
        verify(messages, times(1)).add(any(Message.class));
    }

    /*
     * Scenario for Successful data retrieval.
     */
    @Test
    public void succesfullGetAllMessages() {

        when(consumerRepository.getMessages()).thenReturn(messages);
        Assert.assertEquals(consumerService.getMessages(), messages);
        verify(consumerRepository, times(1)).getMessages();
    }



}