/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1528.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Constants for Buttons
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    public static final int LEFT_JOYSTICK_CLICK = 9;
    public static final int RIGHT_JOYSTICK_CLICK = 10;
    
    //Constants for Axes
    public static final int LEFT_X_AXIS = 0;
    public static final int LEFT_Y_AXIS = 1;
    public static final int LEFT_TRIGGER_AXIS = 2;
    public static final int RIGHT_TRIGGER_AXIS = 3;
    public static final int RIGHT_X_AXIS = 4;
    public static final int RIGHT_Y_AXIS = 5;
    public static final int D_PAD = 6; 
	
    // Motor ID numbers, will likely change based on electronics
    // Drive Motor IDs 
	public static final int LEFT_FRONT = 0;
	public static final int RIGHT_FRONT = 1;
	public static final int LEFT_REAR = 2;
	public static final int RIGHT_REAR = 3;
	
	// Lift Motor IDs
	public static final int LIFT_MOTOR_LOWER_ID = 4;
	public static final int LIFT_MOTOR_UPPER_ID = 5;
	public static final int LEFT_FLYWHEEL_ID = 6;
	public static final int RIGHT_FLYWHEEL_ID = 7;
	
	//Digital Inputs ID numbers, will likely change based on electronics
	public static final int LIMIT_SWITCH_LOWER_ID = 0;
	public static final int LIMIT_SWITCH_UPPER_ID = 1;
	
	// Pneumatic Control Module (PCM) ID numbers, may change based on electronics
	public static final int PUSHER_IN_ID = 0;
	public static final int PUSHER_OUT_ID = 1;
}
