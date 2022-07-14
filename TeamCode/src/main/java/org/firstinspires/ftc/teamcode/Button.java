package org.firstinspires.ftc.teamcode;

public class Button {

    private ButtonType type;
    private int gamepad;

    public Button(ButtonType type, int gamepad) {
        this.type = type;
        this.gamepad = gamepad;
    }
    //test

    public ButtonType getType() {
        return this.type;
    }

    public int getGamepad() {
        return this.gamepad;
    }
}