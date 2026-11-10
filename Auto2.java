package org.firstinspires.ftc.teamcode.Autos;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.sun.tools.javac.code.Scope;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;

import javax.xml.xpath.XPath;

@Autonomous (name= "Auto2", group= "Autonomous")
public class Auto2 {
    private DcMotor leftFront;
    private DcMotor leftBack;
    private DcMotor rightFront;
    private DcMotor rightBack;
    private DcMotor intakeL;
    private DcMotor IntakeM2;
    private DcMotor shooterM1;
    private DcMotor shooterM2;
        {
        DcMotor leftFront = hardwareMap.get(DcMotor.class, "lF"); //from meep meep
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "lB");//from meep meep
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rF");//from meep meep
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rB");//from Meep Meep
        intakeL = hardwareMap.get(DcMotor.class, "intakeL");
        IntakeM2 = hardwareMap.get(DcMotor.class, "IntakeM2");
        shooterM1=hardwareMap.get(DcMotor.class,"shooterM1");
        shooterM2= hardwareMap.get(DcMotor.class, "shooterM2");
        }
    public void runOpMode() {
        int XPath;
        int i =5;
        //number 5 should change moving horizontally
        int YPath;
        int i1 =6;
        //number 6 should change moving vertically
        shooterM1.setPower(1);
        shooterM2.setPower(1);


    }
}

