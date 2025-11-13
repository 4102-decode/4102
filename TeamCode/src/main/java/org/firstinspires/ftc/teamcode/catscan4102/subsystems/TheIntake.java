package org.firstinspires.ftc.teamcode.catscan4102.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class TheIntake extends SubsystemBase {
    private DcMotorEx intake;
    boolean on = false;
    public TheIntake(DcMotorEx intake){
        this.intake = intake;
    }

    public void setOn(){
        on = !on;
    }

    @Override
    public void periodic(){
        if(on){
            intake.setPower(1);
        } else {
            intake.setPower(0);
        }
    }
}
