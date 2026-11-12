package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter extends SubsystemBase {
    private DcMotor shooterM1;
    private DcMotor shooterM2;
    private Servo servoH;

    public Shooter() {
        if (hardwareMap != null) {
            shooterM1 = hardwareMap.get(DcMotor.class, "shooterM1");
            shooterM2 = hardwareMap.get(DcMotor.class, "shooterM2");
            servoH = hardwareMap.get(Servo.class, "sH");
        }
    }

    public Shooter(HardwareMap hwMap) {
        if (hwMap != null) {
            shooterM1 = hwMap.get(DcMotor.class, "shooterM1");
            shooterM2 = hwMap.get(DcMotor.class, "shooterM2");
            servoH = hwMap.get(Servo.class, "sH");
        }
    }

    public Shooter(DcMotor shooterM1, DcMotor shooterM2, Servo servoH) {
        this.shooterM1 = shooterM1;
        this.shooterM2 = shooterM2;
        this.servoH = servoH;
    }

    public void setPower(double power) {
        if (shooterM1 != null) shooterM1.setPower(power);
        if (shooterM2 != null) shooterM2.setPower(power);
    }

    public void shoot() {
        setPower(1.0);
    }

    public void reverse() {
        setPower(-1.0);
    }

    public void stop() {
        setPower(0.0);
    }

    public void setServoPosition(double position) {
        if (servoH != null) {
            servoH.setPosition(position);
        }
    }

    public void telopButton() {
        if (gamepad1 != null) {
            if (gamepad1.right_trigger > 0.2) {
                shoot();
            } else if (gamepad1.right_bumper) {
                reverse();
            } else {
                stop();
            }
        }
    }

    public void telopbutton() {
        if (gamepad1 != null && servoH != null) {
            if (gamepad1.y) {
                servoH.setPosition(1.0); // update target position when calibrated
            } else {
                servoH.setPosition(0.0); // resting position
            }

            if (telemetry != null) {
                telemetry.addData("sH Position", servoH.getPosition());
                telemetry.update();
            }
        }
    }

    public void teleopControl() {
        telopButton();
        telopbutton();
    }
}
