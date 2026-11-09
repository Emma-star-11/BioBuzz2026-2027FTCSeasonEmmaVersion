package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Servo Flower Arm R", group= "TeleOp")
public class ServoControl extends OpMode {
    Servo Rservo;
    Servo Lservo;

    @Override
    public void init() {
        Rservo = hardwareMap.get(Servo.class, "Flower Arm R");
        Lservo= hardwareMap.get(Servo.class,  "Flower Arm R");
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            Rservo.setPosition(1.0);
            Lservo.setPosition(1.0);
            ;
            //change once find position initalized position
        } else {
            Rservo.setPosition(0.0);
            Lservo.setPosition(1.0);
            //change once find position resting position
        }


        telemetry.addData("Servo Position", Rservo.getPosition());
        telemetry.addData("Servo Position", Lservo.getPosition());
        telemetry.update();
    }
}
