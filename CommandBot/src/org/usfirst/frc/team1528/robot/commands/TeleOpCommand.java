package org.usfirst.frc.team1528.robot.commands;

import org.usfirst.frc.team1528.robot.Robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class TeleOpCommand extends Command {

    public TeleOpCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kDriveSystem);
    	//requires(Robot.kLiftSystem);
    	setInterruptible(true);
    	
    }

    private void setQuality(int i) {
		// TODO Auto-generated method stub
		
	}

////	private CameraServer newcameraServer() {
////		// TODO Auto-generated method stub
////		CameraServer camera = newcameraServer();
////    	setQuality(50);
////    	camera.startAutomaticCapture();
////		return null;
//	}

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kPushSystem.pullPistonIn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.kLiftSystem.moveLift();
    	Robot.kDriveSystem.teleOpDrive();
    	System.out.println("driving");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("driving was interrupted");
    	end();
    }
}
