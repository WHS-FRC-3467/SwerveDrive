// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimberConstants;

public class PullArmsDown extends CommandBase {

  ClimberSubsystem m_climber;
  boolean m_end;
  public PullArmsDown(ClimberSubsystem climber) {
    m_climber = climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    m_end = false;
  }

  @Override
  public void execute() {
    if(m_climber.getClimberPosition()< ClimberConstants.kRetracted || m_climber.getClimberPosition() > -300){
      m_climber.drive(-1.0);
      m_end = false;
    }
    else if (m_climber.getClimberPosition()< ClimberConstants.kRetracted || m_climber.getClimberPosition() > -300){
      m_climber.drive(-1.0);
      m_end = false;
    }
    else{
      m_climber.drive(0.0);
      m_end = true;
    }    
  }

  @Override
  public void end(boolean interrupted) {
    m_climber.drive(0.0);
  }

  @Override
  public boolean isFinished() {
    return m_end;
  }
}
