package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SDRobot {

    private HardwareMap hardwareMap;

    private DcMotor frontLeftDrive;
    private DcMotor backLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backRightDrive;

    private HashMap<String, DcMotor> motors;
    private HashMap<Drive, List<DcMotor>> driveMotors;

    public SDRobot(HardwareMap hardwareMap) {
        motors = new HashMap<String, DcMotor>();
        driveMotors = new HashMap<Drive, List<DcMotor>>();

        frontLeftDrive = hardwareMap.get(DcMotor.class, "front_left_drive");
        backLeftDrive = hardwareMap.get(DcMotor.class, "back_left_drive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "front_right_drive");
        backRightDrive = hardwareMap.get(DcMotor.class, "back_right_drive");

        List<DcMotor> temp = new ArrayList<DcMotor>();
        temp.add(frontLeftDrive);
        temp.add(frontRightDrive);
        temp.add(backLeftDrive);
        temp.add(backRightDrive);
        driveMotors.put(Drive.ALL, temp);

        temp = new ArrayList<DcMotor>();
        temp.add(frontLeftDrive);
        temp.add(backLeftDrive);
        driveMotors.put(Drive.LEFT, temp);

        temp = new ArrayList<DcMotor>();
        temp.add(frontRightDrive);
        temp.add(backRightDrive);
        driveMotors.put(Drive.RIGHT, temp);

        temp = new ArrayList<DcMotor>();
        temp.add(frontLeftDrive);
        driveMotors.put(Drive.FRONT_LEFT, temp);

        temp = new ArrayList<DcMotor>();
        temp.add(frontRightDrive);
        driveMotors.put(Drive.FRONT_RIGHT, temp);

        temp = new ArrayList<DcMotor>();
        temp.add(backLeftDrive);
        driveMotors.put(Drive.BACK_LEFT, temp);

        temp = new ArrayList<DcMotor>();
        temp.add(backRightDrive);
        driveMotors.put(Drive.BACK_RIGHT, temp);
    }

    public void addMotor(String name) {
        motors.put(name, hardwareMap.get(DcMotor.class, name));
    }

    public DcMotor getMotor(String name) {
        return motors.get(name);
    }

    public void setMotorPower(String name, double power) {
        motors.get(name).setPower(power);
    }

    public void setMotorDirection(String name, double power) {
        motors.get(name).setPower(power);
    }

    public void setMotorMode(String name, DcMotor.RunMode mode) {
        motors.get(name).setMode(mode);
    }

    public void setMotorTargetPosition(String name, int targetPosition) {
        motors.get(name).setTargetPosition(targetPosition);
    }

    public boolean motorIsBusy(String name) {
        return motors.get(name).isBusy();
    }

    public double getMotorPosition(String name) {
        return motors.get(name).getCurrentPosition();
    }

    public List<DcMotor> getDriveMotors(Drive drive) {
        return driveMotors.get(drive);
    }

    public void setDrivePower(Drive drive, double power) {
        List<DcMotor> motors = driveMotors.get(drive);
        for(DcMotor motor : motors) {
            motor.setPower(power);
        }
    }

    public void setDrivePowers(double frontLeft, double backLeft, double frontRight, double backRight) {
        frontLeftDrive.setPower(frontLeft);
        backLeftDrive.setPower(backLeft);
        frontRightDrive.setPower(frontRight);
        backRightDrive.setPower(backRight);
    }

    public void setDriveDirection(Drive drive, DcMotorSimple.Direction direction) {
        List<DcMotor> motors = driveMotors.get(drive);
        for(DcMotor motor : motors) {
            motor.setDirection(direction);
        }
    }

    public void setDriveDirections(DcMotorSimple.Direction frontLeft, DcMotorSimple.Direction frontRight,
                                   DcMotorSimple.Direction backLeft, DcMotorSimple.Direction backRight) {
        frontLeftDrive.setDirection(frontLeft);
        backLeftDrive.setDirection(backLeft);
        frontRightDrive.setDirection(frontRight);
        backRightDrive.setDirection(backRight);
    }

    public void setDriveMode(Drive drive, DcMotor.RunMode runMode) {
        List<DcMotor> motors = driveMotors.get(drive);
        for(DcMotor motor : motors) {
            motor.setMode(runMode);
        }
    }

    public void setDriveTargetPosition(Drive drive, int targetPosition) {
        List<DcMotor> motors = driveMotors.get(drive);
        for(DcMotor motor : motors) {
            motor.setTargetPosition(targetPosition);
        }
    }

    public boolean driveIsBusy(Drive drive) {
        return driveMotors.get(drive).get(0).isBusy();
    }

    public double getDriveMotorPosition(Drive drive) {
        return driveMotors.get(drive).get(0).getCurrentPosition();
    }
}
