package com.parcom.usercache.model.user;

import com.parcom.security_client.AsyncUserUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class UserListener {

    private final UserService userService;

    @KafkaListener(topics = "${parcom.kafka.topic.user}", groupId = "${parcom.kafka.group.user-cache}")
    public void listen(@Payload Long idUser, @Header("X-Auth-Token") String token) {
        log.info("Get message from broker");
        AsyncUserUtils.authByToken(token);
        userService.delete(idUser);
    }


}
