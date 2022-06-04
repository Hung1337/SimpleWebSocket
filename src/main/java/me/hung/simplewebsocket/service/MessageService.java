package me.hung.simplewebsocket.service;

import me.hung.simplewebsocket.entity.MessageEntity;
import me.hung.simplewebsocket.utils.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 13:03
 */

@Service
public class MessageService {

    @Autowired
    private SocketPoolService socketPoolService;

    private boolean send(WebSocketSession session, MessageEntity message) {
        if (session == null) {
            return false;
        }
        try {
            session.sendMessage(new TextMessage(JsonHelper.toJson(message)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean sendMessageBySession(String sessionId, MessageEntity message) {
        WebSocketSession webSocketSession = socketPoolService.getSessionById(sessionId);
        return send(webSocketSession, message);
    }

    public boolean sendMessageByUsername(String username, MessageEntity message) {
        WebSocketSession webSocketSession = socketPoolService.getSessionByUsername(username);
        return send(webSocketSession, message);
    }

}
