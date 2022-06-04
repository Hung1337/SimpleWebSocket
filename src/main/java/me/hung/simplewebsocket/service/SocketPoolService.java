package me.hung.simplewebsocket.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 12:31
 */

@Service
@Data
public class SocketPoolService {

    private ArrayList<WebSocketSession> activeSessions = new ArrayList<>();

    public void addSession(WebSocketSession socketSession) {

        activeSessions.add(socketSession);

    }

    public void deleteSession(WebSocketSession socketSession) {
        activeSessions.remove(socketSession);
    }

    public WebSocketSession getSessionById(String id) {
        return activeSessions
                .parallelStream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseGet(null);
    }

    public WebSocketSession getSessionByUsername(String username) {
        for (WebSocketSession activeSession : activeSessions) {
            if (activeSession.getPrincipal() != null
                    && activeSession.getPrincipal().getName().equals(username)) {
                return activeSession;
            }
        }
        return null;
    }


}
