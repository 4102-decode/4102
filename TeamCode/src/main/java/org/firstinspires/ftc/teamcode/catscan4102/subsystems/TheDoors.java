package org.firstinspires.ftc.teamcode.catscan4102.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.SubsystemBase;

@Config
public class TheDoors extends SubsystemBase {
    private Servo doorLeft, doorRight;
    private boolean leftUp = false, rightUp = false;
    public TheDoors(Servo doorLeft, Servo doorRight){
        this.doorLeft = doorLeft;
        this.doorRight = doorRight;
    }

    public void open(boolean leftUp, boolean rightUp){
        this.leftUp = leftUp;
        this.rightUp = rightUp;
    }

    public void periodic(){
        if(leftUp){
            doorLeft.setPosition(.75);
        } else {
            doorLeft.setPosition(.5);
        }

        if(rightUp){
            doorRight.setPosition(.75);
        } else {
            doorRight.setPosition(.5);
        }
    }
}
