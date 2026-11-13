package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
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

    public ServoArm (HardwareMap hardwareMap){
        Rservo = hardwareMap.get(Servo.class, "armR");
        Lservo = hardwareMap.get(Servo.class, "armL");
    }

    public void telopButton() {
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
