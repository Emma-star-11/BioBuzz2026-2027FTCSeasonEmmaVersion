package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 *
 */
//CONFIGUR HUB TO THE NAMES
//MAKE SURE TO CONFIGURE DRIVER HUB TO THESE NAMES!!!!!!!!!
public class ServoBallBlocker extends SubsystemBase{
        Servo BBservo = null;
public ServoBallBlocker(HardwareMap hardwareMap) {

    BBservo = hardwareMap.get(Servo.class, "sB");
}
public void telopButton(){
        if (gamepad1.bWasPressed()) {
            BBservo.setPosition(0.0);
            ;
            //change once find position initalized position
        } else {
            BBservo.setPosition(0.0);
            //change once find position resting position

            telemetry.addData("sB", BBservo.getPosition());
            telemetry.update();
        }
    }
}
