package com.shivansh.inksync.controller;

import com.shivansh.inksync.dto.EditMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EditController {

    @MessageMapping("/edit/{docId}")
    @SendTo("/topic/notes/{docId}")
    public EditMessage handleEdit(
            @DestinationVariable String docId,
            EditMessage message
    ) {

        return message;
    }
}