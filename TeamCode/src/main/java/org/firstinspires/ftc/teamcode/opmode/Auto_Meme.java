package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.AutonomousConfig;
import org.firstinspires.ftc.teamcode.RobotCore;
import org.firstinspires.ftc.teamcode.drivetrain.HolonomicDrivetrain;

@Autonomous(name = "Auto_Meme")
public class Auto_Meme extends LinearOpMode {
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

        waitForStart();
        timer.reset();

        while (!isStopRequested()) {
            robot.vectorDrive(-1, 0, AutonomousConfig.sinA * Math.sin(AutonomousConfig.sinGamma * getRuntime()));
        }

        robot.vectorDrive(0,0,0);
    }
}
