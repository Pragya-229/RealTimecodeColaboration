import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/collaboration")
public class WebSocketServer {
    private static final CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        broadcastParticipants();
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        for (Session s : sessions) {
            if (s.isOpen() && !s.equals(session)) {
                s.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        broadcastParticipants();
    }

    private void broadcastParticipants() {
        String participantList = sessions.stream()
                .map(Session::getId)
                .reduce("", (a, b) -> a + ", " + b);
        for (Session s : sessions) {
            if (s.isOpen()) {
                s.getAsyncRemote().sendText("Participants: " + participantList);
            }
        }
    }
}
