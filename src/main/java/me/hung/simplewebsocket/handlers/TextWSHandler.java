package me.hung.simplewebsocket.handlers;

import me.hung.simplewebsocket.entity.MessageEntity;
import me.hung.simplewebsocket.service.MessageService;
import me.hung.simplewebsocket.service.SocketPoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 12:06
 */
@Component
public class TextWSHandler extends TextWebSocketHandler {

    private final Logger LOG = LoggerFactory.getLogger(TextWSHandler.class);

    @Autowired
    private SocketPoolService socketPoolService;

    @Autowired
    private MessageService messageService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        socketPoolService.addSession(session);
        LOG.debug("К веб-сокету подключился новый клиент! ID сессии: {}", session.getId());
        messageService.sendMessageBySession(session.getId(), new MessageEntity("Admin", "Hello!"));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        LOG.debug("Произошла ошибка у {}. Ошибка: {}", session.getId(), exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        socketPoolService.deleteSession(session);
        LOG.debug("От веб-сокета отключился клиент! ID сессии: {}", session.getId());
    }


}
