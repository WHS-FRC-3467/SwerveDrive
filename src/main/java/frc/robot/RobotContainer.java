// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Control.XBoxControllerButton;
import frc.robot.Control.XBoxControllerEE;
import frc.robot.Feedback.Cameras.LimelightSubsystem;
import frc.robot.Subsystems.Climber.Climb;
import frc.robot.Subsystems.Climber.ClimberSubsystem;
import frc.robot.Subsystems.Drive.DriveSubsystem;
import frc.robot.Subsystems.Drive.SwerveDrive;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();

  private final XBoxControllerEE m_driverController = new XBoxControllerEE(0);
  private final XBoxControllerEE m_opperaterController = new XBoxControllerEE(1);

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {  
    DriverStation.silenceJoystickConnectionWarning(true);
    // Comment out for simulation

    m_chooser.addOption("No Auto", null);
    m_chooser.setDefaultOption("No Auto", null);

    SmartDashboard.putData("Auto Chooser", m_chooser);


    LimelightSubsystem.initialize();
    LimelightSubsystem.setDriverMode();

    // Configure the button bindings
    configureButtonBindings();
    
    
    m_driveSubsystem.setDefaultCommand(new SwerveDrive(m_driveSubsystem, 
                                      () -> ((m_driverController.getLeftY())) * DriveSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
                                      () -> -((m_driverController.getLeftX())) * DriveSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
                                      () -> -((m_driverController.getRightX())) * DriveSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND));

  } 

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Driver Controller
      
    // Back button zeros the gyroscope
    new XBoxControllerButton(m_driverController, XBoxControllerEE.Button.kBack)
        .whenPressed(m_driveSubsystem::zeroGyroscope, m_driveSubsystem);

    new XBoxControllerButton(m_opperaterController, XBoxControllerEE.Button.kY)
        .whileHeld(new Climb(m_climberSubsystem, 1));

    new XBoxControllerButton(m_opperaterController, XBoxControllerEE.Button.kA)
        .whileHeld(new Climb(m_climberSubsystem, -1));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}
