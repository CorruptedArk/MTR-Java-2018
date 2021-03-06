/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1528.robot;

import org.usfirst.frc.team1528.robot.commands.ClampPistonCommand;
import org.usfirst.frc.team1528.robot.commands.GrabBoxCommand;
import org.usfirst.frc.team1528.robot.commands.ReleaseBoxCommand;
import org.usfirst.frc.team1528.robot.commands.ScaleDownCommand;
import org.usfirst.frc.team1528.robot.commands.ScaleUpCommand;
import org.usfirst.frc.team1528.robot.commands.StopFlywheelsCommand;
import org.usfirst.frc.team1528.robot.commands.TogglePistonCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static final double ZERO_MARGIN = 0.18;
	public static Joystick stick = new Joystick(0);
	public static Joystick partner = new Joystick(1);
	//public static Button grabButton = new JoystickButton(stick, RobotMap.X_BUTTON);
	//public static Button releaseButton = new JoystickButton(stick, RobotMap.B_BUTTON);
	public static Button scaleUpButton = new JoystickButton(stick, RobotMap.LEFT_BUMPER);
	public static Button scaleDownButton = new JoystickButton(stick, RobotMap.RIGHT_BUMPER);
	public static Button pistonToggleButton = new JoystickButton(partner, RobotMap.A_BUTTON);
	public static Button clampToggleButton = new JoystickButton(partner, RobotMap.B_BUTTON);
	
	public OI() {
		//grabButton.whileHeld(new GrabBoxCommand());
		//grabButton.whenReleased(new StopFlywheelsCommand());
		
		//releaseButton.whileHeld(new ReleaseBoxCommand());
		//releaseButton.whenReleased(new StopFlywheelsCommand());
		
		scaleUpButton.whenPressed(new ScaleUpCommand());
		scaleDownButton.whenPressed(new ScaleDownCommand());
		
		pistonToggleButton.whenPressed(new TogglePistonCommand());
		clampToggleButton.whenPressed(new ClampPistonCommand());
	}
	
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
    public static double buffer(int axisNum, Joystick joystickName, boolean inverted, double highMargin, double lowMargin) {
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
    public static double buffer(int axisNum, Joystick joystickName, boolean inverted, double highMargin, double lowMargin, double scale) {
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
}
