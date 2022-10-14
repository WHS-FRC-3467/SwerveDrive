// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Climber;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CalibrateClimber extends CommandBase {

  ClimberSubsystem m_climber;
  boolean m_done = false;
  boolean m_finished = false;
  Timer m_timer = new Timer();
  
  public CalibrateClimber(ClimberSubsystem climber) {
    m_climber = climber;
    addRequirements(m_climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_done = false;
    m_finished = false;
    m_timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (!m_done) {
      m_done = m_climber.calibrate();
    }

    /*
     * When arms are pulled down and turned off, they bounce up a little bit
     * So we need to wait a bit after we have turned them off before we zero the sensors
     */
    if (m_done) {
      // Start timer
      m_timer.start();
      // Wait for a minimum of 1 seconds
      if (m_timer.hasElapsed(2.0)) {
        m_finished = true;
      }
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climber.drive(0.0);
    m_climber.zeroSensors();
    m_timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_finished;
  }
}
