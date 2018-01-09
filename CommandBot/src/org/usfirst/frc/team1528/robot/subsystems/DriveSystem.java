package org.usfirst.frc.team1528.robot.subsystems;

import org.usfirst.frc.team1528.robot.OI;
import org.usfirst.frc.team1528.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
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
	
	
	/**
     * This function buffers Joystick.getRawAxis() input.
     * If the raw axis output is between lowMargin and highMargin, 
     * buffer will automatically return 0
     * @param axisNum The ID for the axis of a Joystick.
     * @param joystickName The Joystick that input is coming from. 
     * @param inverted If true, buffer will return the negative of the raw axis value
     * @param highMargin The high margin of the buffer.
     * @param lowMargin The low margin of the buffer.
     * @return moveOut - The buffered axis data from joystickName.getRawAxis().
     **/
    private double buffer(int axisNum, Joystick joystickName, boolean inverted, double highMargin, double lowMargin) {
        double moveIn = joystickName.getRawAxis(axisNum);
        double moveOut;
        moveOut = 0.0;
        
        if(moveIn >= lowMargin && moveIn <= highMargin ) {
            moveOut = 0.0;
        }
        else{
            if(inverted){
                moveOut = -moveIn;
            }
            else if(!inverted){ 
                moveOut = moveIn;
            }    
        }
	
        return moveOut;
   }
   
    
    /**
     * This function buffers Joystick.getRawAxis() input.
     * If the raw axis output is between lowMargin and highMargin, 
     * buffer will automatically return 0
     * @param axisNum The ID for the axis of a Joystick.
     * @param joystickName The Joystick that input is coming from. 
     * @param inverted If true, buffer will negate the raw axis value
     * @param highMargin The high margin of the buffer.
     * @param lowMargin The low margin of the buffer.
     * @param scale The magnitude that the raw axis value is multiplied by
     * @return moveOut - The buffered axis data from joystickName.getRawAxis().
     **/
    private double buffer(int axisNum, Joystick joystickName, boolean inverted, double highMargin, double lowMargin, double scale) {
        double moveIn = joystickName.getRawAxis(axisNum);
        double moveOut;
        moveOut = 0.0;
        
        if(moveIn >= lowMargin && moveIn <= highMargin ) {
            moveOut = 0.0;
        }
        else{
            if(inverted){
                moveOut = -moveIn;
            }
            else if(!inverted){ 
                moveOut = moveIn;
            }    
        }
        
        scale = Math.abs(scale);
        
        if(scale >= 1){
            scale = 1;
        }
        
        moveOut = moveOut*scale;
        
        return moveOut;
   }
	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void teleOpDrive() {
		double ySpeed = buffer(RobotMap.LEFT_Y_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN);
		double xSpeed = buffer(RobotMap.LEFT_X_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN);
		double zRotation = buffer(RobotMap.RIGHT_X_AXIS, OI.stick, false, OI.ZERO_MARGIN, -OI.ZERO_MARGIN);
		
		drive.driveCartesian(ySpeed, xSpeed, zRotation);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

