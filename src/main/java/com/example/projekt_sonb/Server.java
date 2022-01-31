package com.example.projekt_sonb;

import com.example.projekt_sonb.controls.ButtonAction;
import com.example.projekt_sonb.controls.ButtonInputFaultMode;
import com.example.projekt_sonb.controls.ButtonResultFaultMode;
import com.example.projekt_sonb.other_classes.InputFaultMode;
import com.example.projekt_sonb.other_classes.InputGenerator;
import com.example.projekt_sonb.other_classes.ResultFaultMode;
import com.example.projekt_sonb.other_classes.ServerMode;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Random;

@Data
@EqualsAndHashCode(callSuper = true)
public class Server extends Button {
    public static final String SERVER_NAME = "Server ";
    private int serverId;
    private String server;
    private SimpleIntegerProperty input;
    private SimpleIntegerProperty faultValue;
    private SimpleIntegerProperty result;
    private ServerMode serverMode;
    private InputFaultMode inputFaultMode;
    private ResultFaultMode resultFaultMode;
    private Button actionButton;
    private Button inputFaultModeButton;
    private Button resultFaultModeButton;

    public Server(int serverID) {
        input = new SimpleIntegerProperty(0);
        result = new SimpleIntegerProperty(0);
        this.serverId = serverID;
        this.server = SERVER_NAME + serverId;
        this.actionButton = new ButtonAction("Stop", "Start", this);
        this.inputFaultModeButton = new ButtonInputFaultMode(InputFaultMode.NONE, this);
        this.resultFaultModeButton = new ButtonResultFaultMode(ResultFaultMode.NONE, this);
        this.faultValue = new SimpleIntegerProperty(new Random().nextInt(-10, 11));
        setServerMode(ServerMode.RUN);
    }

    /////////////////////////// Input ///////////////////////////////////
    public IntegerProperty inputProperty() {
        return input;
    }

    public void setInput(int input) {
        this.input.set(input);
    }

    public int getInput() {
        return input.get();
    }

    /////////////////////////// Fault ///////////////////////////////////
    public IntegerProperty faultValueProperty() {
        return faultValue;
    }

    public void setFaultValue(int faultValue) {
        this.faultValue.set(faultValue);
    }

    public int getFaultValue() {
        return faultValue.get();
    }

    /////////////////////////// Result /////////////////////////////////
    public IntegerProperty resultProperty() {
        return result;
    }

    public void setResult(int result) {
        this.result.set(result);
    }

    public int getResult() {
        return result.get();
    }

    /////////////////////////// Server //////////////////////////////////
    public String getServer() {
        return server;
    }

    public ServerMode getServerMode() {
        return serverMode;
    }

    /////////////////////////////////////////////////////////////////////
     @Override
     public void fire() {
       actionButton.fire();
     }

    //////////////////////////// Silnia /////////////////////////////////
    private static int silnia(int i) {
        if (i < 1)
            return 1;
        else
            return i * silnia(i - 1);
    }

    /////////////////////////////////////////////////////////////////////
    Thread thread = new Thread(this::run);

    private void run() {
        while (true) {
            if (ServerMode.RUN.equals(serverMode)) {
                if (InputFaultMode.NONE.equals(inputFaultMode)) {
                    setInput(InputGenerator.gen);
                    if (ResultFaultMode.NONE.equals(resultFaultMode)) {
                        setFaultValue(0);
                    } else if (ResultFaultMode.AUTO.equals(resultFaultMode)) {
                        setFaultValue((new Random().nextInt(-1, 2)));
                    } else if (ResultFaultMode.MANUAL.equals(resultFaultMode)) {
                    }
                } else if (InputFaultMode.MANUAL.equals(inputFaultMode)) {
                    if (ResultFaultMode.NONE.equals(resultFaultMode)) {
                        setFaultValue(0);
                    } else if (ResultFaultMode.AUTO.equals(resultFaultMode)) {
                        setFaultValue((new Random().nextInt(-1, 2)));
                    } else if (ResultFaultMode.MANUAL.equals(resultFaultMode)) {
                    }
                } else if (InputFaultMode.AUTO.equals(inputFaultMode)) {
                    setInput((new Random().nextInt(3, 7)));
                    if (ResultFaultMode.NONE.equals(resultFaultMode)) {
                        setFaultValue(0);
                    } else if (ResultFaultMode.AUTO.equals(resultFaultMode)) {
                        setFaultValue((new Random().nextInt(-1, 2)));
                    } else if (ResultFaultMode.MANUAL.equals(resultFaultMode)) {
                    }
                }
                setResult((silnia(getInput())) + getFaultValue());
            } else {
                setResult(0);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}