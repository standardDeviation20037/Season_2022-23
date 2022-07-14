package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@TeleOp(name="SD_TeleOp", group="Iterative OpMode")
public class SD_TeleOp extends OpMode {

    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix cameraLocation;

    public static final String VUFORIA_KEY = "AUwWd/X/////AAABmXBvwC4YtUYhobPZmBANtUVmen6Q/60keakx5OUvCFzszapZQRBAzVDNzgxCOT7gCavUPLDTEInvUIhr07bDBq082eth97lNKwMGFGQtrnxCnL8bueTXgQ/C9/Hz3kQ4aMu42ZYskWCQSIlArOOPYbQVfujc+5415hGR7H9JB7qNTsZw4XLr/wSUbzrdQimGr0SvsIFTEuKrBpjdguhSSfi1hiAbYnY8YEyV76JHqtYq1S+VXL//Za0MbdBCJI8+ZSWgreEdCqr1nqnzHpUmxzQADhQ87n4DpZNgM00GXHPel/041ft+cyMcRZz2Ubny4rjAw96coVc6M95wfenHaqHnHchaZtmg4gYXggqxpKwd";
    SDRobot robot;

    @Override
    public void init() {
        robot = new SDRobot(hardwareMap);
        robot.setDriveDirection(Drive.LEFT, DcMotorSimple.Direction.REVERSE);
        Controls.setGamepads(gamepad1, gamepad2);
    }

    @Override
    public void loop() {
        robot.setDrivePower(Drive.ALL, 1);
        telemetry.update();
    }
}