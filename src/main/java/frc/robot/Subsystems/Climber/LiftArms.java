// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimberConstants;

public class LiftArms extends CommandBase {

  ClimberSubsystem m_climber;
  boolean m_end;
  public LiftArms(ClimberSubsystem climber)
  {
    
    m_climber = climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    m_end = false;
  }

  @Override
  public void execute() {
    // Extend Arms to Maximum Length
    m_climber.setClimberPosition(ClimberConstants.kRaised);
    // m_end = m_climber.atPosition();
  }

  @Override
  public void end(boolean interrupted) {
    m_climber.drive(0.0);
  }

  @Override
  public boolean isFinished() {
    // If Arms are at Max Length
    return m_end;
  }
}
