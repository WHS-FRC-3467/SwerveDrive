package frc.robot.IMU;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 *
 */
public class ZeroGyro extends InstantCommand {

	private final IMU m_imu;

	public ZeroGyro(IMU imu_subsys) {
		m_imu = imu_subsys;
	}
	
    public void execute() {
    	m_imu.zeroAngle();
    }
    
}
