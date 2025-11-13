package org.firstinspires.ftc.teamcode.catscan4102.subsystems;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class Bot {
    public DcMotorEx frontRight, frontLeft, backRight, backLeft, intake;
    public Servo sortLeft, sortRight, kickLeft, kickRight, hoodLeft, hoodRight;
    public MotorEx shooterLeft, shooterRight;
    public TheHood hood;
    public TheIntake theIntake;
    public TheKickerLeft kickerLeft;
    public TheKickerRight kickerRight;
    public TheShooter shooter;
    public Limelight3A limelight;
    public Follower follower;
    public TheDoors doors;

    public Bot(HardwareMap hMap, Pose startPose, boolean teleOp){
        limelight = hMap.get(Limelight3A.class, "limelight");
        frontLeft = hMap.get(DcMotorEx.class,"frontLeft");
        backLeft = hMap.get(DcMotorEx.class,"backLeft");
        frontRight = hMap.get(DcMotorEx.class,"frontRight");
        backRight = hMap.get(DcMotorEx.class,"backRight");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        shooterLeft = new MotorEx(hMap, "shooterLeft");
        shooterRight = new MotorEx(hMap, "shooterRight");
        kickLeft = hMap.get(Servo.class, "kickerLeft");
        kickRight = hMap.get(Servo.class, "kickerRight");
        hoodLeft = hMap.get(Servo.class, "hoodLeft");
        hoodRight = hMap.get(Servo.class, "hoodRight");
        sortLeft = hMap.get(Servo.class, "sortLeft");
        sortRight = hMap.get(Servo.class, "sortRight");
        shooterRight.setInverted(true);
        intake = hMap.get(DcMotorEx.class,"intake");
        intake.setDirection(DcMotor.Direction.REVERSE);
        shooterLeft.setRunMode(Motor.RunMode.VelocityControl);
        shooterRight.setRunMode(Motor.RunMode.VelocityControl);
        shooterRight.setVeloCoefficients(0.5, 0.0012, 0.32);
        shooterLeft.setVeloCoefficients(0.5, 0.0012, 0.32);
        shooterLeft.setFeedforwardCoefficients(0.92, 0.47, 0.3);
        shooterRight.setFeedforwardCoefficients(0.92, 0.47, 0.3);
        shooterLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        shooterRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        limelight.setPollRateHz(100);
        limelight.pipelineSwitch(0);
        follower = Constants.createFollower(hMap);
        follower.setStartingPose(startPose);

        doors = new TheDoors(sortLeft, sortRight);
        hood = new TheHood(hoodLeft, hoodRight);
        theIntake = new TheIntake(intake);
        kickerLeft = new TheKickerLeft(kickLeft);
        kickerRight = new TheKickerRight(kickRight);
        shooter = new TheShooter(shooterLeft, shooterRight);
        CommandScheduler.getInstance().registerSubsystem(hood, theIntake, kickerLeft, kickerRight, shooter);
    }

    public void loop(){
        CommandScheduler.getInstance().run();
        TelemetryUtil.addData("v", intake.getVelocity());
        follower.update();
    }
}
