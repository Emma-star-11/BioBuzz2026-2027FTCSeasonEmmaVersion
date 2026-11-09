package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name= "Telop-MoveForward", group= "TelOp")
public class MecanumDrive extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    private IMU imu;
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "lF");
        leftBack = hardwareMap.get(DcMotor.class, "lB");
        rightFront = hardwareMap.get(DcMotor.class, "rF");
        rightBack = hardwareMap.get(DcMotor.class, "rB");
        //names of motors
        //Ports: lF=1 bL=0, rF=3, rB-2
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);

        leftFront.setPower(1);
        rightFront.setPower(1);
        leftBack.setPower(1);
        rightBack.setPower(1);

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        );

        double heading = imu.getRobotYawPitchRollAngles()
                .getYaw(AngleUnit.RADIANS);
        double rotatedX = x * Math.cos(-heading)
                - y * Math.sin(-heading);
        double rotatedY = x * Math.sin(-heading)
                + y * Math.cos(-heading);
        double denominator = Math.max(
                Math.abs(rotatedY)
                        + Math.abs(rotatedX)
                        + Math.abs(turn),

        leftFront.setPower((rotatedY + rotatedX + turn) / denominator);
        leftBack.setPower((rotatedY - rotatedX + turn) / denominator);
        rightFront.setPower((rotatedY - rotatedX - turn) / denominator);
        rightBack.setPower((rotatedY + rotatedX - turn) / denominator);
    }

    }