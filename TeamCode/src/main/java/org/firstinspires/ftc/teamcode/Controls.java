package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

import java.util.HashMap;

public class Controls {

    private static HashMap<String, Button> bindings = new HashMap<String, Button>();

    private static Gamepad gamepad1;
    private static Gamepad gamepad2;

    public static final int GAMEPAD_1 = 1;
    public static final int GAMEPAD_2 = 2;

    public static void setGamepads(Gamepad gp1, Gamepad gp2) {
        gamepad1 = gp1;
        gamepad2 = gp2;
    }

    public static void bind(String control, ButtonType button) {
        bind(control, button, GAMEPAD_1);
    }

    public static void bind(String control, ButtonType button, int gamepad) {
        bindings.put(control, new Button(button, gamepad));
    }

    public static boolean getBoolean(String control) {
        Button button = bindings.get(control);
        Gamepad gamepad = (button.getGamepad() == GAMEPAD_1) ? gamepad1 : gamepad2;
        ButtonType type = button.getType();

        if(type == ButtonType.A) {
            return gamepad.a;
        } else if(type == ButtonType.B) {
            return gamepad.b;
        } else if(type == ButtonType.X) {
            return gamepad.x;
        } else if(type == ButtonType.Y) {
            return gamepad.y;
        } else if(type == ButtonType.LB) {
            return gamepad.left_bumper;
        } else if(type == ButtonType.RB) {
            return gamepad.right_bumper;
        }

        return false;
    }

    public static double getDouble(String control) {
        Button button = bindings.get(control);
        Gamepad gamepad = (button.getGamepad() == GAMEPAD_1) ? gamepad1 : gamepad2;
        ButtonType type = button.getType();

        if(type == ButtonType.LEFT_STICK_X) {
            return gamepad.left_stick_x;
        } else if(type == ButtonType.LEFT_STICK_Y) {
            return gamepad.left_stick_y;
        } else if(type == ButtonType.RIGHT_STICK_X) {
            return gamepad.right_stick_x;
        } else if(type == ButtonType.RIGHT_STICK_Y) {
            return gamepad.right_stick_y;
        } else if(type == ButtonType.LT) {
            return gamepad.left_trigger;
        } else if(type == ButtonType.RT) {
            return gamepad.right_trigger;
        }

        return 0;
    }
}
