package org.firstinspires.ftc.teamcode.Autos;

import static android.os.SystemClock.sleep;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name= "Auto-MoveForward", group= "Autonomous")
public class Auto1 {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    public void runOpMode() {
        leftFront = hardwareMap.get (DcMotor.class, "lF");
        leftBack = hardwareMap.get (DcMotor.class, "lB");
        rightFront = hardwareMap.get (DcMotor.class, "rF");
        rightBack = hardwareMap.get (DcMotor.class, "rB");
        //names of motors
        //Ports: lF=1 bL=0, rF=3, rB-2

       leftFront.setPower(1);
       leftBack.setPower(1);
       rightFront.setPower(1);
       rightBack.setPower(1);
        //1 mean's full power of motor, minimum can go to is -1 (backward) and max is 1 (forward) .5 if half,-.5 is half backwards etc...
        sleep(2000);
        //2000 is 2 seconds I think

        leftBack.setPower(0.0);
        leftFront.setPower(0.0);
        rightBack.setPower(0.0);
        rightFront.setPower(0.0);

    }
    }


