// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import frc.robot.Util.Gains;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final boolean tuningMode = false;

    public static final class CanConstants{
        //drivebase CAN IDs 
        public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 1; 
        public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 2; 
        public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 3; 
        public static final int BACK_LEFT_MODULE_STEER_MOTOR = 4; 
        public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 5; 
        public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 6; 
        public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 7; 
        public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 8; 
        public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 9; 
        public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 10; 
        public static final int BACK_LEFT_MODULE_STEER_ENCODER = 11; 
        public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 12; 
        
        public static final int CLIMBER_MOTOR = 14;
        
		//non drivebase CAN IDs
        public static final int DRIVETRAIN_PIGEON_ID = 13; 
    }
	
    public static final class RobotConstants {
        //
        // Robot physical dimensions and mass quantities.
        //

        // The left-to-right distance between the drivetrain wheels
        // * Should be measured from center to center.
        public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.5334; // 21 inches
        
        // The front-to-back distance between the drivetrain wheels.
        // * Should be measured from center to center.
        public static final double DRIVETRAIN_WHEELBASE_METERS = 0.5334;  // 21 inches
    }
 
    public static final class DriveConstants{
        public static final double DEADBAND= 0.2;
        public static final boolean PRACTICE = true;
    
        public static final SwerveDriveKinematics DRIVETRAIN_KINEMATICS = new SwerveDriveKinematics(
            new Translation2d(RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            new Translation2d(RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            new Translation2d(-RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            new Translation2d(-RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0)
        );

        public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(103.0);
        public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(291.1);
        public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(139.7); 
        public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(97.4);

    }
    public static final class ClimberConstants{

    
        /**
         * 
         * PID Gains may have to be adjusted based on the responsiveness of control loop.
         * kF: 1023 represents output value to Talon at 100%, 6800 represents Velocity units at 100% output
         * 
         * 	                                    			   kP   kI   kD   kF   Iz   PeakOut */
        public final static Gains kClimberGains = new Gains(0.1, 0.0, 0.0, 0, 0, 1.00 );
	
	    /* Motor neutral dead-band : Range 0.001 -> 0.25 */
	    public final static double kNeutralDeadband = 0.001;

	    /* Current Limit for arm calibration */
        public final static double kCalibCurrentLimit = 10.0;

        /**
    	 * Set to zero to skip waiting for confirmation.
	     * Set to nonzero to wait and report to DS if action fails.
	    */
	    public final static int kTimeoutMs = 30;

        // Motion Magic constants
        public static final int kTolerance = 500;

        // Setpoints (in encoder ticks) (not tuned)
        public static final double kRetracted = 0.0;

        public static final double kOffGround = 30000.0;

    
        public static final double kRaised = 460000.0;

    }
}
