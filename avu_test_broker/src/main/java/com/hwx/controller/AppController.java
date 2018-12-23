package com.hwx.controller;

import com.hwx.Constant;
import com.hwx.model.Message;
import com.hwx.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.JAXBException;


@Controller
public class AppController {

    @Autowired
    MessageService messageService;

    /*
        Эндпоинт формы для создания сообщения.
     */
    @GetMapping(value={"/add", "/"})
    public String prepareMessage(ModelMap modelMap) {
        Message message = new Message();
        modelMap.addAttribute("message", message);
        modelMap.addAttribute("pickVariantMap", Constant.PICK_VARIANTS_MAP);
        return "index_message";
    }

    /*
        Эндпоинт для обработки формы сообщений
     */
    @PostMapping("/add")
    public String handleMessage(Message message, BindingResult result,
                                ModelMap model) throws JAXBException {
        if (result.hasErrors()) {
            model.addAttribute("info_block", "failed on binding!");
            return "message_success";
        }
        messageService.putMessage(message);

        model.addAttribute("info_block", "Message sended!");
        return "message_success";
    }
}
