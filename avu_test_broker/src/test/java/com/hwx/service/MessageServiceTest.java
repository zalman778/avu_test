package com.hwx.service;


import com.hwx.jms.MessageBroker;
import com.hwx.model.Message;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class MessageServiceTest {

    @Mock
    MessageBroker messageBroker;

    @InjectMocks
    MessageServiceImpl messageService;

    @Captor
    ArgumentCaptor<String> captor;

    private String value = "test";
    private Message msg = new Message();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void succesfullMessageSending() {
        /*
         * Instruct mockito to do nothing when broker.sendMessage will be called.
         */
        doNothing().when(messageBroker).sendMessage(any(String.class));
        messageBroker.sendMessage(value);

        /*
         * Verify that dao.sendMessage was indeed called one time.
         */
        verify(messageBroker, times(1)).sendMessage(captor.capture());
        /*
         * Assert that broker.sendMessage was called with a particular String, assert string details
         */
        Assert.assertEquals(captor.getValue(), value);
    }


}
