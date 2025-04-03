package hieu.notificationservice.controller;

import hieu.notificationservice.dto.MessageDto;
import hieu.notificationservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final EmailService emailService;

    @PostMapping("/send-notification")
    public void sendNotification(@RequestBody MessageDto messageDto) {
        emailService.sendEmail(messageDto);
    }
}
