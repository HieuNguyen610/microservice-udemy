package hieu.notificationservice.service;

import hieu.notificationservice.dto.MessageDto;

public interface EmailService {
    void sendEmail(MessageDto messageDto);
}
