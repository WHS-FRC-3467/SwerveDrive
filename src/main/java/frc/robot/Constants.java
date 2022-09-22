// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

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
        public static final double kDeadBand = 0.2;
        public static final boolean PRACTICE = true;
    
        public static final SwerveDriveKinematics DRIVETRAIN_KINEMATICS = new SwerveDriveKinematics(
            new Translation2d(RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            new Translation2d(RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            new Translation2d(-RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
            new Translation2d(-RobotConstants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -RobotConstants.DRIVETRAIN_WHEELBASE_METERS / 2.0)
        );

        public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(277.1);
        public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(161.8);
        public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(116.7); 
        public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(284.1);

        // Limelight auto aim X-axis target tolerance. This is the number of degrees
        // from perfect center that the robot will consider the BasicLimelightAim
        // command "finished".
        public static final double LIMELIGHT_X_TOLERANCE = 1.0;

        // Maximum Limelight auto-aim rotation velocity in radians per second.
        public static final double LIMELIGHT_X_VELOCITY_LIMIT = 0.5;

        // Limelight auto-aim X-axis P-gain.
        public static final double LIMELIGHT_X_P = 10.0;

            
        public static final double precisionSpeed = 0.25;

        //meters per second
        public static final double SimpleAutoVelocity = 1.0;
    }


    
}
