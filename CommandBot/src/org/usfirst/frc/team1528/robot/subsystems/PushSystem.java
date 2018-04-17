package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PushSystem extends Subsystem {
	
	private DoubleSolenoid pusher = new DoubleSolenoid(RobotMap.PUSHER_OUT_ID, RobotMap.PUSHER_IN_ID);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void pushPistonOut() {
		pusher.set(Value.kForward);
	}
	
	public void pullPistonIn() {
		pusher.set(Value.kReverse);
	}
	
	public void togglePiston() {
		if(pusher.get() == Value.kOff)
		{
			pushPistonOut();
		}
		else if(pusher.get() == Value.kReverse)
		{
			pushPistonOut();
		}
		else
		{
			pullPistonIn();
		}
		
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

