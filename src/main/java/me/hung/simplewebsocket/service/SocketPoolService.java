package me.hung.simplewebsocket.service;

import lombok.Data;
import me.hung.simplewebsocket.entity.WSSession;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<WebSocketSession> getActiveSessions() {
        return activeSessions;
    }

    public List<WSSession> getWSSessions() {
        List<WSSession> sessions = new ArrayList<>();
        for (WebSocketSession activeSession : this.activeSessions) {
            Principal principal = activeSession.getPrincipal();
            String username = principal == null ? "Null" : principal.getName();
            sessions.add(new WSSession(activeSession.getId(), username));
        }
        return sessions;
    }

}
