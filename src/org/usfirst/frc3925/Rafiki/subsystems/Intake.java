// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3925.Rafiki.subsystems;

import org.usfirst.frc3925.Rafiki.RobotMap;
import org.usfirst.frc3925.Rafiki.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Intake extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController upperLeft = RobotMap.intakeUpperLeft;
    SpeedController upperRight = RobotMap.intakeUpperRight;
    SpeedController lowerLeft = RobotMap.intakeLowerLeft;
    SpeedController lowerRight = RobotMap.intakeLowerRight;
    DoubleSolenoid solenoidLeft = RobotMap.intakeSolenoidLeft;
    DoubleSolenoid solenoidRight = RobotMap.intakeSolenoidRight;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    protected IntakeState state = IntakeState.OPEN;
    
    public static enum IntakeState {
    	OPEN, CLOSED;
    }
    
    /**
     * positive = pull in, negative = push out
     * @param speed  speed of motors
     */
    public void setRawSpeeds(double speed) {
    	upperLeft.set(speed); //TODO Check directions
    	upperRight.set(-speed);
    	lowerLeft.set(-speed);
    	lowerRight.set(-speed);
    }
    
    public void run() {
    	switch (state) {
    	case OPEN:
    		solenoidLeft.set(Value.kReverse);
    		solenoidRight.set(Value.kReverse);
    		break;
		case CLOSED:
			solenoidLeft.set(Value.kForward);
			solenoidRight.set(Value.kForward);
			break;

		default:
			break;
		}
    }
    
    public void setState(IntakeState state) {
    	this.state = state;
    }
    
    
    public void logData() {
    	SmartDashboard.putString("IntakeState", state.toString());
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new IntakeControl());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}

