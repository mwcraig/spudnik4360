/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class mainClass extends IterativeRobot {
    //hi
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    Compressor mainCompressor = new Compressor(1, 1);
    RobotDrive mainDrive = new RobotDrive(1, 2);
    Solenoid pistonOneOut = new Solenoid(1);
    Solenoid pistonOneIn = new Solenoid(2);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        mainCompressor.start();

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        mainDrive.tankDrive(leftStick, rightStick);
        if(leftStick.getRawButton(3)){
            pistonOneOut.set(true);
            pistonOneIn.set(false);
        }else if(leftStick.getRawButton(2)){
            pistonOneIn.set(true);
            pistonOneOut.set(false);
        }else{
            pistonOneOut.set(false);
            pistonOneIn.set(false);
        }
        
        
    
    
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
