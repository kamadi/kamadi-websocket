package kz.kamadi.websocket;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * A simple WebSocketServer implementation. Keeps track of a "chatroom".
 */
public class ChatServer extends WebSocketServer {

    private ResponseHandler responseHandler;

    public ChatServer(int port, ResponseHandler responseHandler) throws UnknownHostException {
        super(new InetSocketAddress(port));
        this.responseHandler = responseHandler;
    }

    public ChatServer(InetSocketAddress address, ResponseHandler responseHandler) {
        super(address);
        this.responseHandler = responseHandler;
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        broadcast("new connection: " + handshake.getResourceDescriptor());

        System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        broadcast(conn + " has left the room!");
        System.out.println(conn + " has left the room!");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        broadcast(message);
        System.out.println(conn + ": " + message);
        responseHandler.onMessage(conn,message);
        System.out.println(conn + ": " + message);
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message) {
        broadcast(message.array());
        System.out.println(conn + ": " + message);
    }


    @Override
    public void onFragment(WebSocket conn, Framedata fragment) {
        System.out.println("received fragment: " + fragment);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        WebSocketImpl.DEBUG = true;
        int port = 12221; // 843 flash policy port
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception ex) {
        }
        ChatServer s = new ChatServer(port, new ResponseHandler(new DeviceInteractorImpl()));
        s.start();
        System.out.println("ChatServer started on port: " + s.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            s.broadcast(in);
            if (in.equals("exit")) {
                s.stop(1000);
                break;
            }
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            // some errors like port binding failed may not be assignable to a specific websocket
        }
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
    }

}
