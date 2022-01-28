package com.example.projekt_sonb;

import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import com.example.projekt_sonb.other_classes.InputGenerator;
import com.example.projekt_sonb.voter.Voter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;


public class GuiController implements Initializable {
    // Liczba serwerów
    @FXML
    int n = 6;

    @FXML
    private TableView<Server> TabServ;
    //@FXML private TableColumn<Server, String> ActionColumn;
    @FXML
    private TableColumn<Server, String> ServerColumn;
    //@FXML private TableColumn<Server, String> InputModeColumn;
    @FXML
    private TableColumn<Server, Integer> InputColumn;
    //@FXML private TableColumn<Server, String> FaultModeColumn;
    @FXML
    private TableColumn<Server, Integer> FaultValueColumn;
    @FXML
    private TableColumn<Server, Integer> ResultColumn;
    @FXML
    public Label clockLabel;
    @FXML
    public TextArea clockArea;
    @FXML
    public Label wynikLabel;
    @FXML
    public TextArea wynikArea;

    @FXML
    public void onClick() {
        clockLabel.setText("Przeliczono:");

    }

    //@Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Server> lista = FXCollections.observableArrayList();
        TabServ.setItems(lista);

        Server[] server = new Server[n];
        for (int i = 0; i < n; i++) {
            server[i] = new Server(i + 1);
            //server[i].Server = "Server " + (i + 1);
            lista.add(server[i]);
            server[i].thread.setDaemon(true);
            server[i].thread.start();
        }

        InputGenerator generator = new InputGenerator();
        //IntStream.range(1, 7)
        //        .mapToObj(index -> new Server(index, random.nextInt(1, 10)))
        //.forEach(i ->server[i].thread.; = "SOS");
        //        .forEach(lista::add);


        // IntStream.range(1, 6)
        //  .forEach(i -> TabServ.getColumns());//.get(i));//.setStyle("-fx-alignment: CENTER;"));
///////////////////////////////////////////////////////////////
        Thread thread0 = new Thread(() -> {
            while (true) {
                LocalTime lt = LocalTime.now();
                String text = lt.format(DateTimeFormatter.
                        ofLocalizedTime(FormatStyle.MEDIUM));
                System.out.println(text);
                clockArea.setText(text);
                System.out.println(Voter.vote(Stream.of(server[0].getResult(), server[1].getResult(), server[2].getResult(),
                        server[3].getResult(), server[4].getResult(), server[5].getResult())));

                String txt = String.valueOf((Voter.vote(Stream.of(server[0].getResult(), server[1].getResult(), server[2].getResult(),
                        server[3].getResult(), server[4].getResult(), server[5].getResult()))));
                wynikArea.setText(txt);

                try {
                    Thread.sleep(Duration.ofSeconds(1).toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread0.setDaemon(true);
        thread0.start();

/////////////////////////////////////////////////////////////////////////
        //TabServ.getSelectionModel().setCellSelectionEnabled(true);
        //TabServ.setItems(lista);

        //ActionColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getServer()));

        ServerColumn.setCellValueFactory(new PropertyValueFactory<>("server"));
        //ServerColumn.setEditable(true);
        //ServerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //ServerColumn.setCellValueFactory(data -> new String(data.getValue().getServer()));

        InputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
        InputColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        InputColumn.setOnEditCommit((value) -> value.getRowValue().setInput(value.getNewValue()));

        FaultValueColumn.setCellValueFactory(new PropertyValueFactory<>("faultValue"));
        FaultValueColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        FaultValueColumn.setOnEditCommit((value) -> value.getRowValue().setFaultValue(value.getNewValue()));

        ResultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        ResultColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ResultColumn.setOnEditCommit((value) -> value.getRowValue().setResult(value.getNewValue()));
    }
}