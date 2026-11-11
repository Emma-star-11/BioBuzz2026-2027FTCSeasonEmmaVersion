package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 *
 */
//CONFIGUR HUB TO THE NAMES
//MAKE SURE TO CONFIGURE DRIVER HUB TO THESE NAMES!!!!!!!!!
@TeleOp(name="TeleOp - Field Centric Mecanum", group= "TeleOp")
public class ServoControl extends OpMode {

    //FLOWER ARM
    Servo Rservo;
    Servo Lservo;

    @Override
    public void init() {
        Rservo = hardwareMap.get(Servo.class, "armR");
        Lservo = hardwareMap.get(Servo.class, "armL");
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_down) { //up and down depends on driver comfort
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

        //ADJUSTABLE HOOD

        Servo AHservo = null;

        Rservo = hardwareMap.get(Servo.class, "AHservo");
        if (gamepad1.yWasPressed()) {
            AHservo.setPosition(0.0);
            ;
            //change once find position initalized position
        } else {
            AHservo.setPosition(0.0);
            //change once find position resting position

            telemetry.addData("Servo Position", AHservo.getPosition());
            telemetry.update();
        }


        //BALL BLOCKER

        Servo BBservo = null;

        Rservo = hardwareMap.get(Servo.class, "BBservo");
        if (gamepad1.bWasPressed()) {
            BBservo.setPosition(0.0);
            ;
            //change once find position initalized position
        } else {
            BBservo.setPosition(0.0);
            //change once find position resting position

            telemetry.addData("Servo Position", BBservo.getPosition());
            telemetry.update();
        }
    }
}
