package com.zhang.springcloud.controller;

import com.zhang.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-07 17:39
 * @Version 1.0
 **/
@RestController
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

}
