package com.hwx.service;

import com.hwx.config.AppConfig;
import com.hwx.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={AppConfig.class})
public class MessageServiceImplTest {

    @Autowired
    MessageService messageService;

    @Test
    public void putMessage() {
        Message testMessage = new Message();
        testMessage.setDateValue(new Date());
        testMessage.setIntValue(1);
        testMessage.setPickValue(1);

        String result = messageService.putMessage(testMessage);
        assertTrue(result.equals("OK"));
    }
}


