package kz.kamadi.websocket;

import com.google.gson.Gson;
import kz.kamadi.websocket.model.Action;
import kz.kamadi.websocket.model.Message;
import kz.kamadi.websocket.model.Status;
import org.java_websocket.WebSocket;

public class ResponseHandler {

    public DeviceInteractor deviceInteractor;

    public Gson gson;

    public ResponseHandler(DeviceInteractor deviceInteractor) {
        this.deviceInteractor = deviceInteractor;
        gson = new Gson();
    }

    public void onMessage(WebSocket connection, String message) {
        try {
            Gson gson = new Gson();
            Message request = gson.fromJson(message, Message.class);
            System.out.println("request: " + request);

            switch (request.getAction()) {
                case STATUS:
                    handleStatus(connection);
                    break;
                case INFO:
                    handleInfo(connection);
                    break;
                case WRITE:
                    handleWrite(connection,request);
                    break;
                case ON_CARD_OVER:
                    handleOnCardOver(connection,request);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleStatus(WebSocket connection) {
        Message message = new Message();
        message.setAction(Action.STATUS);
        message.setStatus(new Status(Status.SUCCESS, "Request was successfully processed"));
        String reply = gson.toJson(message);
        System.out.println("response: " + message);
        connection.send(reply);
    }

    private void handleInfo(WebSocket connection) {
        Message message = new Message();
        message.setAction(Action.INFO);
        message.setStatus(new Status(Status.SUCCESS, "Request was successfully processed"));
        message.setCim("KZ-430300-D2J8A80000");
        message.setTid("00E214342D010101D83034460F07260103F0F1FF00001299");
        message.setSgtin("4814999647629e4");
        String reply = gson.toJson(message);
        System.out.println("response: " + message);
        connection.send(reply);
    }

    private void handleWrite(WebSocket connection, Message request) {
        Message message = new Message();
        message.setAction(Action.WRITE);
        message.setStatus(new Status(Status.SUCCESS, "Request was successfully processed"));
        message.setProduct(request.getProduct());
        String reply = gson.toJson(message);
        System.out.println("response: " + message);
        connection.send(reply);
    }

    private void handleOnCardOver(WebSocket connection, Message request) {
        Message message = new Message();
        message.setAction(Action.WRITE);
        message.setStatus(new Status(Status.SUCCESS, "Request was successfully processed"));
        message.setParameter(request.getParameter());
        String reply = gson.toJson(message);
        System.out.println("response: " + message);
        connection.send(reply);
    }
}

