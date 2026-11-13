package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.ServoArm;
import org.firstinspires.ftc.teamcode.subsystems.ServoBallBlocker;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class TelOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Intake intake= new Intake(hardwareMap);
        MecanumDrive mecanumDrive= new MecanumDrive(hardwareMap);
        ServoArm servoArm= new ServoArm(hardwareMap);
        ServoBallBlocker servoBallBlocker= new ServoBallBlocker(hardwareMap);
        Shooter shooter= new Shooter(hardwareMap);
    waitForStart();
    while (opModeIsActive()){
        intake.telopButton();
        mecanumDrive.telopButton(gamepad1,telemetry);
        servoArm.telopButton();
        servoBallBlocker.telopButton();
        shooter.telopButton();
    }
    }
}
