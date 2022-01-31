package com.example.projekt_sonb.controls;

import com.example.projekt_sonb.Server;
import com.example.projekt_sonb.other_classes.ServerMode;
import javafx.scene.control.Button;

public class ButtonAction extends Button {
    private final String initialMessage;
    private final String afterClickMessage;
    private final Server server;

    public ButtonAction(String initialMessage, String afterClickMessage, Server server) {
        super(initialMessage);
        this.initialMessage = initialMessage;
        this.afterClickMessage = afterClickMessage;
        this.server = server;
    }

    @Override
    public void fire() {
        if (!server.getServerMode().equals(ServerMode.RUN)) {
            this.setText(initialMessage);
            server.setServerMode(ServerMode.RUN);
        } else {
            this.setText(afterClickMessage);
            server.setServerMode(ServerMode.STOP);
        }
        super.fire();
    }
}
