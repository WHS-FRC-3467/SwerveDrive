// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.CanConstants;
import frc.robot.Constants.ClimberConstants;

public class ClimberSubsystem extends SubsystemBase {
  	// Climber Winch Motors
  	TalonFX m_climber = new TalonFX(CanConstants.CLIMBER_MOTOR);


  	int m_setpoint;
  	/** Creates a new ClimberSubsystem. */
  	public ClimberSubsystem() {
		// Zero the encoders
		zeroSensors();
    
		/* Disable all motor controllers */
		m_climber.set(TalonFXControlMode.PercentOutput, 0);

		/* Set Neutral Mode */
		m_climber.setNeutralMode(NeutralMode.Brake);
  	}


	@Override
		public void periodic() {
    	SmartDashboard.putNumber("Climber Position", m_climber.getSelectedSensorPosition());
	}

  
	public void drive(double speed) {
		m_climber.set(ControlMode.PercentOutput, speed);
	}

	public double getClimberPosition(){
		return m_climber.getSelectedSensorPosition();
	}


	public boolean calibrate() {

		boolean isFinished = false;
		double current = 0.0;

		current = m_climber.getStatorCurrent();
		// SmartDashboard.putNumber("Calib Curr " + (left ? "L: " : "R: "), current);
		if (current < ClimberConstants.kCalibCurrentLimit) {
			m_climber.set(ControlMode.PercentOutput, -0.20);
			isFinished = false;
		} else {
			m_climber.set(ControlMode.PercentOutput, 0.0);
			isFinished = true;
		}
		return isFinished;
	}



	/** Zero integrated encoders on Talons */
	void zeroSensors() {
		m_climber.getSensorCollection().setIntegratedSensorPosition(0, ClimberConstants.kTimeoutMs);
		//System.out.println("[Integrated Sensors] All sensors are zeroed.\n");
	}

}
