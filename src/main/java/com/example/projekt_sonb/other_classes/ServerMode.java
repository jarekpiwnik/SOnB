package com.example.projekt_sonb.other_classes;

import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ServerMode {
    STOPPED,
    RUNNING;
    //STOPPED(Color.WHITE, Color.BLACK),
   // RUNNING(Color.WHITE, Color.DARKGREEN);
   // ERROR(Color.WHITE, Color.DARKRED);

   // @Getter private final Color textColor;
   // @Getter private final Color bgColor;
}
