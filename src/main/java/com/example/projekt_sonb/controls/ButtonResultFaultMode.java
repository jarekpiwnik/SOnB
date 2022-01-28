package com.example.projekt_sonb.controls;

import com.example.projekt_sonb.other_classes.ResultFaultMode;
import com.example.projekt_sonb.Server;
import javafx.scene.control.Button;

public class ButtonResultFaultMode extends Button {
    private final Server server;

    public ButtonResultFaultMode(ResultFaultMode init, Server server) {
        super(init.toString());
        this.server = server;
        server.setResultFaultMode(init);
    }

    @Override
    public void fire() {
        server.setResultFaultMode(server.getResultFaultMode().next());
        this.setText(server.getResultFaultMode().toString());
        super.fire();
    }
}
