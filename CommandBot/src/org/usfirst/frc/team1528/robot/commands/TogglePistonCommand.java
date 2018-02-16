package org.usfirst.frc.team1528.robot.commands;

import org.usfirst.frc.team1528.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TogglePistonCommand extends Command {

	boolean isCommandFinished;
    
	public TogglePistonCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kPushSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isCommandFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kPushSystem.togglePiston();
    	isCommandFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCommandFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
