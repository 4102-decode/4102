package org.firstinspires.ftc.teamcode.catscan4102.commands;

import com.seattlesolvers.solverslib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.catscan4102.subsystems.Bot;

public class ActivateKickerR extends InstantCommand {
    private Bot bot;
    public ActivateKickerR(Bot bot){
        this.bot = bot;
    }

    @Override
    public void initialize() {
        bot.kickerRight.setUp();
    }
}