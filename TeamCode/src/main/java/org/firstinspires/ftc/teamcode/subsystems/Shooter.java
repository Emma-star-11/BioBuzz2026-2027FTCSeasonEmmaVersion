package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//@TeleOp(name= "TeleOp - Field Centric Mecanum", group= "TelOp")
public class Shooter extends SubsystemBase {
    private DcMotor shooterM1;
    private DcMotor shooterM2;
    private Servo servoH;

    //  public Shooter (DcMotor shooterM1, DcMotor shooterM2)
    public Shooter() {
        shooterM1 = shooterM1;
        shooterM2 = hardwareMap.get(DcMotor.class, "ShooterM2");
        shooterM1 = hardwareMap.get(DcMotor.class, "shooterM1");
    }

    public void telopButton() {
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
    }

    public ServoArm () {
        servoH = hardwareMap.get(Servo.class, "sH");
    }
    public void telopbutton() {
        if (gamepad1.yWasPressed()) {
            servoH.setPosition(0.0);
            ;
            //change once find position initalized position
        } else {
            servoH.setPosition(0.0);
            //change once find position resting position

            telemetry.addData("sH", servoH.getPosition());
            telemetry.update();
        }
    }
}
