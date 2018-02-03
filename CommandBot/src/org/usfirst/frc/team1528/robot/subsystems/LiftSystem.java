package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.OI;
import org.usfirst.frc.team1528.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftSystem extends Subsystem {
	Talon liftMotorLower = new Talon(RobotMap.LIFT_MOTOR_LOWER_ID); 
	Talon liftMotorUpper = new Talon(RobotMap.LIFT_MOTOR_UPPER_ID);
	
	Talon leftFlywheelMotor = new Talon(RobotMap.LEFT_FLYWHEEL_ID);
	Talon rightFlywheelMotor = new Talon(RobotMap.RIGHT_FLYWHEEL_ID);
	
	DigitalInput limitSwitchLower = new DigitalInput(RobotMap.LIMIT_SWITCH_LOWER_ID);
	DigitalInput limitSwitchUpper = new DigitalInput(RobotMap.LIMIT_SWITCH_UPPER_ID);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void moveLift()
	{
		double upMotorValue = OI.buffer(RobotMap.LEFT_TRIGGER_AXIS,OI.stick,false,OI.ZERO_MARGIN,-OI.ZERO_MARGIN);
		double downMotorValue = OI.buffer(RobotMap.RIGHT_TRIGGER_AXIS,OI.stick,false,OI.ZERO_MARGIN,-OI.ZERO_MARGIN);
		
		double totalMotorValue = upMotorValue + downMotorValue;
		
		if(limitSwitchLower.get()){ //Lift has reached first limit switch, so first motor can't move
			
			liftMotorLower.setSpeed(0);
			if(limitSwitchUpper.get()) { //Lift has reached second limit switch and second motor can't go up
				
				if(totalMotorValue < 0) { // Lift is trying to go down, allow it
					liftMotorUpper.setSpeed(totalMotorValue);
				}
				else { // Lift is trying to go up, don't allow it
					liftMotorUpper.setSpeed(0);
				}
			}
			else // Lift is in between first and second switches, second motor can move freely
			{
				liftMotorUpper.setSpeed(totalMotorValue);
			}
		}
		else { //Lift is below first switch, only first motor can move
			liftMotorLower.setSpeed(totalMotorValue);	
		}

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

