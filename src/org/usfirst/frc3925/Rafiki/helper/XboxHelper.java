package org.usfirst.frc3925.Rafiki.helper;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc3925.Rafiki.Robot;

import edu.wpi.first.wpilibj.Joystick;

public class XboxHelper {
	private XboxHelper() {}
	
	public static enum CurrentXbox {
		DRIVER, SHOOTER;
	}
	
	public static final int
	A = 1,
	B = 2,
	X = 3,
	Y = 4,
	TRIGGER_LT = 5,
	TRIGGER_RT = 6,
	BACK = 7,
	START = 8,
	STICK_LEFT = 9,
	STICK_RIGHT = 10,
	
	AXIS_LEFT_Y = 1,
	AXIS_LEFT_X = 2,
	AXIS_RIGHT_Y = 3,
	AXIS_RIGHT_X = 4,
	AXIS_TRIGGER_LEFT = 5,
	AXIS_TRIGGER_RIGHT = 6;
	
	
	private static Map<CurrentXbox, Joystick> controllers = new HashMap<>();
	
	public static void init() {
		controllers.put(CurrentXbox.DRIVER, Robot.oi.driver);
		controllers.put(CurrentXbox.SHOOTER, Robot.oi.shooter);
	}
	
	public static double getAxis(CurrentXbox xbox, int axis) {
		return Math.abs(controllers.get(xbox).getRawAxis(axis)) > Constants.XBOX_AXIS_TOLERANCE ? controllers.get(xbox).getRawAxis(axis) : 0;
	}
	
	public static boolean getButton(CurrentXbox xbox, int button) {
		return controllers.get(xbox).getRawButton(button);
	}
	
	public static double getPOV(CurrentXbox xbox) {
		return controllers.get(xbox).getPOV();
	}
	
}
