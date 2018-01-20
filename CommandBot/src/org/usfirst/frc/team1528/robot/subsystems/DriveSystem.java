package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.OI;
import org.usfirst.frc.team1528.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveSystem extends Subsystem {
	Talon leftFront = new Talon(RobotMap.LEFT_FRONT);
	Talon rightFront = new Talon(RobotMap.RIGHT_FRONT);
	Talon leftRear = new Talon(RobotMap.LEFT_REAR);
	Talon rightRear = new Talon(RobotMap.RIGHT_REAR);
	
	MecanumDrive drive = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveSystem() {
		super();
		
		
		
	}
	
	public void teleOpDrive() {
		double ySpeed = OI.buffer(RobotMap.LEFT_Y_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN);
		double xSpeed = OI.buffer(RobotMap.LEFT_X_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN);
		double zRotation = OI.buffer(RobotMap.RIGHT_X_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN);
		
		drive.driveCartesian(ySpeed, xSpeed, zRotation);
	}
	
	// numbers not final, will need to be changed during testing
	public void autoDriveLeft() {
		drive.driveCartesian(1.0, 0.0, 0.0);
		Timer.delay(0.5);
		drive.driveCartesian(0.0, -1.0, 0.0);
		Timer.delay(0.1);
		drive.driveCartesian(0.0, 0.0, 0.0);
	}

	// numbers not final, will need to be changed during testing
	public void autoDriveRight() {
		drive.driveCartesian(1.0, 0.0, 0.0);
		Timer.delay(0.5);
		drive.driveCartesian(0.0, 1.0, 0.0);
		Timer.delay(0.1);
		drive.driveCartesian(0.0, 0.0, 0.0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

