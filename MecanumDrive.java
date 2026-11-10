package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

//@TeleOp(name = "TeleOp - Field Centric Mecanum", group = "TeleOp")
public class MecanumDrive extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Initialize motors using hardware map names: lF, lB, rF, rB
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "lF");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "lB");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rF");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rB");

        // Motor directions
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        // Zero power behavior
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initialize IMU
        IMU imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        );
        imu.initialize(parameters);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Reversed stick Y on FTC gamepads
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double turn = gamepad1.right_stick_x;

            // Press Options / Back to reset IMU yaw heading calibration
            if (gamepad1.options || gamepad1.back) {
                imu.resetYaw();
            }

            double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            // Rotate stick coordinates by robot heading for field-centric orientation
            double rotatedX = x * Math.cos(-heading) - y * Math.sin(-heading);
            double rotatedY = x * Math.sin(-heading) + y * Math.cos(-heading);

            // Normalize motor powers so none exceed 1.0
            double denominator = Math.max(Math.abs(rotatedY) + Math.abs(rotatedX) + Math.abs(turn), 1.0);

            double frontLeftPower = (rotatedY + rotatedX + turn) / denominator;
            double backLeftPower = (rotatedY - rotatedX + turn) / denominator;
            double frontRightPower = (rotatedY - rotatedX - turn) / denominator;
            double backRightPower = (rotatedY + rotatedX - turn) / denominator;

            leftFront.setPower(frontLeftPower);
            leftBack.setPower(backLeftPower);
            rightFront.setPower(frontRightPower);
            rightBack.setPower(backRightPower);

            telemetry.addData("Heading (degrees)", Math.toDegrees(heading));
            telemetry.update();
        }
    }
}
