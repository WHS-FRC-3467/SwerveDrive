package frc.robot.IMU;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IMU extends SubsystemBase {

	TalonSRX m_pigeonTalon;
	PigeonIMU m_pidgey;
	PigeonIMU.GeneralStatus m_genStatus;
	double [] m_ypr = new double[3];
	double [] m_xyz_dps = new double [3];
	
	// Static subsystem reference
	private static IMU imuInstance = new IMU();

	public static IMU getInstance() {
		return IMU.imuInstance;
	}
	
	/* Constructor */
	protected IMU() {
		
		m_pigeonTalon = new TalonSRX(13);
		m_pidgey = new PigeonIMU(m_pigeonTalon);
		m_genStatus = new PigeonIMU.GeneralStatus();

		/* reset heading, angle measurement wraps at plus/minus 23,040 degrees (64 rotations) */
		m_pidgey.setYaw(0.0, 10);
		
	}
	
    /* Update all the data and display to Dashboard */
    public void displayIMUUpdate() {

		/* grab data from Pigeon */
		m_pidgey.getGeneralStatus(m_genStatus);
		
		SmartDashboard.putNumber("Current Angle",  getCurrentAngle());
		SmartDashboard.putBoolean("Is Angle Good?", (m_pidgey.getState() == PigeonIMU.PigeonState.Ready) ? true : false);
		SmartDashboard.putNumber("Current Angular Rate", getCurrentAngularRate());

    }
    
    public boolean isAngleValid() {
    	return(m_pidgey.getState() == PigeonIMU.PigeonState.Ready);
    }
    
    public double getCurrentAngle() {
		return (-m_pidgey.getFusedHeading());
	}
	
	public Rotation2d getAngle(){
		return Rotation2d.fromDegrees(getCurrentAngle());
	}
    
    public double getCurrentAngularRate() {
		m_pidgey.getRawGyro(m_xyz_dps);
		return (-m_xyz_dps[2]);
    }
    
    public void zeroAngle() {
    	m_pidgey.setYaw(0.0, 0);
    }
}

