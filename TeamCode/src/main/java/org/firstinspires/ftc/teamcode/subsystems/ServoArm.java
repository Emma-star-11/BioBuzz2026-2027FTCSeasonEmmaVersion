package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

/**
 *
 */
//CONFIGUR HUB TO THE NAMES
//MAKE SURE TO CONFIGURE DRIVER HUB TO THESE NAMES!!!!!!!!!
public class ServoArm extends SubsystemBase {

    //FLOWER ARM
    Servo Rservo;
    Servo Lservo;

    public ServoArm (){
        Rservo = hardwareMap.get(Servo.class, "armR");
        Lservo = hardwareMap.get(Servo.class, "armL");
    }

    public void telopbutton() {
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
    }
}
