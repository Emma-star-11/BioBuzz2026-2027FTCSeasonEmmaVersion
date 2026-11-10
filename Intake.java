package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.button.Trigger;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.security.PrivateKey;

@TeleOp(name= "TeleOp - Field Centric Mecanum", group= "TelOp")
public class Intake {
    private DcMotor intakeL;
    private DcMotor IntakeM2;

    {
    }

    public Intake(DcMotor intakeL, DcMotor IntakeM2) {

        intakeL = hardwareMap.get(DcMotor.class, "intakeL");
        IntakeM2 = hardwareMap.get(DcMotor.class, "IntakeM2");
        if (gamepad1.left_trigger_pressed) {
            intakeL.setPower(1.0);
            IntakeM2.setPower(1.0);
            ;
            //change once find position initalized position
        } else if (gamepad1.left_bumper) {
                intakeL.setPower(-1.0);
                IntakeM2.setPower(-1.0);
                ;
                //change once find position initalized position
            } else {
                intakeL.setPower(0.0);
                IntakeM2.setPower(0.0);
            }
        }
    }

