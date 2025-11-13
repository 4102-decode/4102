package org.firstinspires.ftc.teamcode.catscan4102.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.catscan4102.subsystems.Bot;

public class ActivateIntake extends InstantCommand {
    private Bot bot;
    public ActivateIntake(Bot bot){
        this.bot = bot;
    }

    public void initialize(){
        bot.theIntake.setOn();
    }

}
