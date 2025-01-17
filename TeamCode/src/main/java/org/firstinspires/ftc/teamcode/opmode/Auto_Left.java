package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.AutonomousConfig;
import org.firstinspires.ftc.teamcode.RobotCore;
import org.firstinspires.ftc.teamcode.drivetrain.HolonomicDrivetrain;

@Autonomous(name = "Auto_Red")
public class Auto_Left extends LinearOpMode {
    private RobotCore robot;
    private ElapsedTime timer;

    private Servo ClampLeft;
    private Servo ClampRight;

    private void sleep(double ms) throws InterruptedException {
        double init = timer.milliseconds();
        while ( (timer.milliseconds() - init) < ms) {

        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new RobotCore(hardwareMap, HolonomicDrivetrain.class);
        timer = robot.timer;

        robot.registerDefaults();

        ClampLeft = hardwareMap.get(Servo.class, "ClampLeft");
        ClampRight = hardwareMap.get(Servo.class, "ClampRight");

        waitForStart();
        timer.reset();

        robot.vectorDrive(-1, -0.85, 0);
        sleep(AutonomousConfig.Time1);

        robot.vectorDrive(0,0,0);
        ClampLeft.setPosition(.3);
        ClampRight.setPosition(.5);
        sleep(AutonomousConfig.ClampDelay);

        robot.vectorDrive(1,0,0);
        sleep(AutonomousConfig.Time2);

        ClampLeft.setDirection(Servo.Direction.REVERSE);
        ClampLeft.setPosition(0);
        ClampRight.setPosition(0);
        sleep(AutonomousConfig.ClampDelay);

        robot.vectorDrive(0,1,0);
        sleep(AutonomousConfig.Time3);

        robot.vectorDrive(0,0,0);
    }
}
