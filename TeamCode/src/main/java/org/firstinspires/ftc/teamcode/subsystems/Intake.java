package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
public class Intake extends SubsystemBase {
    private DcMotor intakeL;
    private DcMotor IntakeL2;

    public Intake() {

        intakeL = hardwareMap.get(DcMotor.class, "intakeL");
        IntakeL2 = hardwareMap.get(DcMotor.class, "IntakeL2");
    }

    public void telopButton(){
        if (gamepad1.left_trigger_pressed) {
            intakeL.setPower(1.0);
            IntakeL2.setPower(1.0);

            ;
            //change once find position initalized position
        } else if (gamepad1.left_bumper) {
            intakeL.setPower(-1.0);
            IntakeL2.setPower(-1.0);
            ;
            //change once find position initalized position
        } else {
            intakeL.setPower(0.0);
            IntakeL2.setPower(0.0);
        }
    }
    }



