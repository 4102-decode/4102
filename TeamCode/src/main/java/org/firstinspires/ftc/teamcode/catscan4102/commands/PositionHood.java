package org.firstinspires.ftc.teamcode.catscan4102.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.catscan4102.subsystems.Bot;

public class PositionHood extends InstantCommand {
    private Bot bot;
    private double pos;
    public PositionHood(Bot bot, double pos){
        this.bot = bot;
        this.pos = pos;
    }

    public void initialize(){
        bot.hood.setPos(pos);
    }

}
