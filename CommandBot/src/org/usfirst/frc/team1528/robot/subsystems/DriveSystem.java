package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.OI;
import org.usfirst.frc.team1528.robot.RobotMap;
import org.usfirst.frc.team1528.robot.commands.TeleOpCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSystem extends Subsystem {
	private final double SCALE_INCREMENT = 0.1;
	
	private Talon leftFront = new Talon(RobotMap.LEFT_FRONT);
	private Talon rightFront = new Talon(RobotMap.RIGHT_FRONT);
	private Talon leftRear = new Talon(RobotMap.LEFT_REAR);
	private Talon rightRear = new Talon(RobotMap.RIGHT_REAR);
	
	private double scale;
	
	private DifferentialDrive frontDrive = new DifferentialDrive(leftFront, rightFront);
	private DifferentialDrive rearDrive = new DifferentialDrive(leftRear, rightRear);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveSystem() {
		super();
		
		scale = 1;
	}

	private void coordinatedDrive(double leftValue, double rightValue)
	{
		frontDrive.tankDrive(leftValue, rightValue);
		rearDrive.tankDrive(leftValue, rightValue);
	}
	
	
	public void teleOpDrive() {
		frontDrive.setSafetyEnabled(true);
		rearDrive.setSafetyEnabled(true);
		double leftSpeed = OI.buffer(RobotMap.LEFT_Y_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN, scale);
		double rightSpeed = OI.buffer(RobotMap.RIGHT_Y_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN, scale);
		
		coordinatedDrive(leftSpeed, rightSpeed);
		
		System.out.println("scale is " + scale);
	}
	
	public void stop() {
		coordinatedDrive(0,0);
	}
	
	// numbers not final, will need to be changed during testing
	public void autoDriveForward() {
		frontDrive.setSafetyEnabled(false);
		rearDrive.setSafetyEnabled(false);
		Timer.delay(4.0);
		coordinatedDrive(0.3,0.3);
		Timer.delay(2.75);
		stop();
	}
	
	public void autoDriveLeft() {
		frontDrive.setSafetyEnabled(false);
		rearDrive.setSafetyEnabled(false);
		coordinatedDrive(0.3,0.3); // drive forward at 30% power
		Timer.delay(2.75); // delay for 2.75 seconds
		stop();
		coordinatedDrive(-0.3,0.3); // turn left at 30% power
		Timer.delay(0.75); // delay for 0.75 seconds
		stop();
		coordinatedDrive(0.3,0.3); // drive forward at 30% power
		Timer.delay(0.75); // delay for 0.75 seconds
		stop();
		coordinatedDrive(0.3,-0.3); // turn right at 30% power
		Timer.delay(0.75); // delay for 0.75 seconds
		stop();
	}

	// numbers not final, will need to be changed during testing
	public void autoDriveRight() {
		frontDrive.setSafetyEnabled(false);
		rearDrive.setSafetyEnabled(false);
		coordinatedDrive(0.3,0.3); // drive forward at 30% power
		Timer.delay(2.75); // delay for 2.75 seconds
		stop();
		coordinatedDrive(0.3,-0.3); // turn right at 30% power
		Timer.delay(0.75); // delay for 0.75 seconds
		stop();
		coordinatedDrive(0.3,0.3); // drive forward at 30% power
		Timer.delay(0.75); // delay for 0.75 seconds
		stop();
		coordinatedDrive(-0.3,0.3); // turn left at 30% power
		Timer.delay(0.75); // delay for 0.75 seconds
		stop();
	}
	
	public void stepUpScale() {
		stop();
		if(scale < 1) {
			scale += SCALE_INCREMENT;
		}
		System.out.println("scale is " + scale);
	}
	
	public void stepDownScale() {
		stop();
		if(scale > 0)
		{
			scale -= SCALE_INCREMENT;
		}
		System.out.println("scale is " + scale);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleOpCommand());
    }
}

