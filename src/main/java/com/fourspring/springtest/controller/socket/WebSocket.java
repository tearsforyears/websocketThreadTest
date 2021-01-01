package com.fourspring.springtest.controller.socket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocket {


    private Session session;

    private String name;

    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String, WebSocket> webSocketSet = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam(value = "name") String name) {
        this.session = session;
        this.name = name;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketSet.put(name, this);
        System.out.println("[WebSocket] 连接成功，当前连接人数为：" + webSocketSet.size());
    }


    @OnClose
    public void onClose() {
        webSocketSet.remove(this.name);
        System.out.println("[WebSocket] 退出成功，当前连接人数为：" + webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("[WebSocket] 收到消息：" + message);

        //判断是否需要指定发送，具体规则自定义
        String reg = "user ";
        if (message.indexOf(reg) == 0) {
            String name = message.substring(reg.length(), message.indexOf(";"));
            appointSending(name, "[" + this.name + " only says to you] =>" + message.substring(message.indexOf(";") + 1));
        } else {
            groupSending("[" + this.name + " says to all] => " + message);
        }

    }


    public void groupSending(String message) {
        for (String name : webSocketSet.keySet()) {
            try {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void appointSending(String name, String message) {
        try {
            webSocketSet.get(name).session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}