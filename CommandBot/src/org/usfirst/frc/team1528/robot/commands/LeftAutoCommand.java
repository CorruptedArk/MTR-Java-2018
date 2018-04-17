package org.usfirst.frc.team1528.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1528.robot.Robot;

/**
 *
 */
public class LeftAutoCommand extends Command {

	boolean autoIsFinished;
	
    public LeftAutoCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kDriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	autoIsFinished = false;
    	Robot.kPushSystem.pullPistonIn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kDriveSystem.autoDriveLeft();
    	
    	autoIsFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return autoIsFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
