package com.hwx.controller;

import com.hwx.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    /*
        Эндпоинт для получения списка полученных сообщений
     */
    @GetMapping("/list")
    public String getList(ModelMap modelMap) {
        modelMap.addAttribute("messages", consumerService.getMessages());
        return "index_list";
    }

}
