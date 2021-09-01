package frc.robot.IMU;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IMU_ReportStatus extends CommandBase {

	private int counter;
	private final IMU m_imu;
	
	public IMU_ReportStatus(IMU imu_subsys) {
		m_imu = imu_subsys;
	}
	
	public void initialize() {
		counter = 0;
	}

	public void execute() {
		if (counter < 50) {
			counter++;
		}
		else {
			m_imu.displayIMUUpdate();
			counter = 0;
		}
	}

	public boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		end();
	}
}
