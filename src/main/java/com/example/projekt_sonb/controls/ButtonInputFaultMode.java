package com.example.projekt_sonb.controls;

import com.example.projekt_sonb.other_classes.InputFaultMode;
import com.example.projekt_sonb.Server;
import javafx.scene.control.Button;

public class ButtonInputFaultMode extends Button {
    private final Server server;

    public ButtonInputFaultMode(InputFaultMode init, Server server) {
        super(init.toString());
        this.server = server;
        server.setInputFaultMode(init);
    }

    @Override
    public void fire() {
        server.setInputFaultMode(server.getInputFaultMode().next());
        this.setText(server.getInputFaultMode().toString());
        super.fire();
    }
}
