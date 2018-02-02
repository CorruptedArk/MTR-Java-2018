package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.OI;
import org.usfirst.frc.team1528.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftSystem extends Subsystem {
	Talon liftMotor = new Talon(RobotMap.LIFT_MOTOR_ID); 
	
	Talon leftFlywheelMotor = new Talon(RobotMap.LEFT_FLYWHEEL_ID);
	Talon rightFlywheelMotor = new Talon(RobotMap.RIGHT_FLYWHEEL_ID);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void moveLift()
	{
		double upMotorValue = OI.buffer(RobotMap.LEFT_TRIGGER_AXIS,OI.stick,false,OI.ZERO_MARGIN,-OI.ZERO_MARGIN);
		double downMotorValue = OI.buffer(RobotMap.RIGHT_TRIGGER_AXIS,OI.stick,false,OI.ZERO_MARGIN,-OI.ZERO_MARGIN);
		
		double totalMotorValue = upMotorValue + downMotorValue;
		
		liftMotor.setSpeed(totalMotorValue);
	}
	
	public void grabBox()
	{
		leftFlywheelMotor.setSpeed(0.5);
		rightFlywheelMotor.setSpeed(-0.5);
	}
	
	public void releaseBox()
	{
		leftFlywheelMotor.setSpeed(-0.5);
		rightFlywheelMotor.setSpeed(0.5);
	}
	
	public void stopFlywheels()
	{
		leftFlywheelMotor.setSpeed(0);
		rightFlywheelMotor.setSpeed(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

