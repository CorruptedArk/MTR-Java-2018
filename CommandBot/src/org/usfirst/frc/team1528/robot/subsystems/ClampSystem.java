package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClampSystem extends Subsystem {
	
	private DoubleSolenoid clamp = new DoubleSolenoid(RobotMap.CLAMP_OUT_ID, RobotMap.CLAMP_IN_ID);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void pushClampOut() {
		clamp.set(Value.kReverse);
	}
	
	private void pullClampIn() {
		clamp.set(Value.kForward);
	}
	
	public void toggleClamp() {
		if(clamp.get() == Value.kOff)
		{
			pullClampIn();
		}
		else if(clamp.get() == Value.kReverse)
		{
			pullClampIn();
		}
		else
		{
			pushClampOut();
		}
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

