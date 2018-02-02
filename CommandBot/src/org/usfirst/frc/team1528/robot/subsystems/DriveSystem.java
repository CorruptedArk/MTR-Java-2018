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
	private final double SCALE_INCREMENT = 0.1;
	
	private Talon leftFront = new Talon(RobotMap.LEFT_FRONT);
	private Talon rightFront = new Talon(RobotMap.RIGHT_FRONT);
	private Talon leftRear = new Talon(RobotMap.LEFT_REAR);
	private Talon rightRear = new Talon(RobotMap.RIGHT_REAR);
	
	private int scale;
	
	MecanumDrive drive = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveSystem() {
		super();
		
		scale = 1;
	}
	
	public void teleOpDrive() {
		double ySpeed = OI.buffer(RobotMap.LEFT_Y_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN, scale);
		double xSpeed = OI.buffer(RobotMap.LEFT_X_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN, scale);
		double zRotation = OI.buffer(RobotMap.RIGHT_X_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN, scale);
		
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
	
	public void stepUpScale() {
		if(scale < 1) {
			scale += SCALE_INCREMENT;
		}
	}
	
	public void stepDownScale() {
		if(scale > 0)
		{
			scale -= SCALE_INCREMENT;
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

