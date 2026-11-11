package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;

//@TeleOp(name= "TeleOp - Field Centric Mecanum", group= "TelOp")
public class Shooter {
    private DcMotor shooterM1;
    private DcMotor shooterM2; {

    {
    }
  //  public Shooter (DcMotor shooterM1, DcMotor shooterM2); {
        shooterM1 = shooterM1;

        shooterM1 = hardwareMap.get(DcMotor.class, "shooterM1");
        if (gamepad1.right_trigger_pressed) {
            shooterM1.setPower(1.0);
            shooterM2.setPower(1.0);
            ;
        } else if (gamepad1.right_bumper) {
                shooterM1.setPower(-1.0);
                shooterM2.setPower(-1.0);
                ;
            } else {
                shooterM1.setPower(0.0);
                shooterM2.setPower(0.0);
            }
        }///////////
    }

pit