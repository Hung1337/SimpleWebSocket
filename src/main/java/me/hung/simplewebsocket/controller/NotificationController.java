package me.hung.simplewebsocket.controller;

import me.hung.simplewebsocket.entity.MessageEntity;
import me.hung.simplewebsocket.entity.ResponseMessageEntity;
import me.hung.simplewebsocket.service.MessageService;
import me.hung.simplewebsocket.service.SocketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 * @author Danila Avdeyenko
 * @date 09.06.2022 | 7:06
 */


@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private SocketPoolService socketPoolService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/sessions")
    public List<WebSocketSession> getActiveSessions() {
        return socketPoolService.getActiveSessions();
    }

    @PostMapping("/send/{sessionId}")
    public ResponseEntity<?> sendMessageBySessionId(@PathVariable String sessionId,
                                                    @RequestBody MessageEntity message) {

        boolean sent = messageService.sendMessageBySession(sessionId, message);
        if (sent) {
            return ResponseEntity
                    .status(200)
                    .body(new ResponseMessageEntity("Уведомление отправлено!"));
        }

        return ResponseEntity
                .status(500)
                .body(new ResponseMessageEntity("Произошла ошибка. Скорее всего, сессия уже не жива."));

    }

    @PostMapping("/send/{username}")
    public ResponseEntity<?> sendMessageByUsername(@PathVariable String username,
                                                   @RequestBody MessageEntity message) {
        boolean sent = messageService.sendMessageByUsername(username, message);
        if (sent) {
            return ResponseEntity
                    .status(200)
                    .body(new ResponseMessageEntity("Уведомление отправлено!"));
        }

        return ResponseEntity
                .status(500)
                .body(new ResponseMessageEntity("Произошла ошибка. Скорее всего, сессия уже не жива."));
    }

}
