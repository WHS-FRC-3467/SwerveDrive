package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SlewRateLimiter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveDrivetrain;

public class SwerveDriveCommand extends CommandBase {

  private final SwerveDrivetrain drivetrain;
  private final XboxController controller;
  double ySpeedCon;
  double xSpeedCon;
  double rotation;
  // Slew rate limiters to make joystick inputs more gentle; 1/3 sec from 0 to 1.
  private final SlewRateLimiter xspeedLimiter = new SlewRateLimiter(6);
  private final SlewRateLimiter yspeedLimiter = new SlewRateLimiter(6);
  private final SlewRateLimiter rotLimiter = new SlewRateLimiter(6);

  public SwerveDriveCommand(SwerveDrivetrain drivetrain, XboxController controller) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);

    this.controller = controller;
  }

  @Override
  public void execute() {
    
    if(controller.getY(GenericHID.Hand.kLeft) < 0.05)
    {
      ySpeedCon = 0.0;
    }
    else{
      ySpeedCon = controller.getY(GenericHID.Hand.kLeft);
    }

    if(controller.getX(GenericHID.Hand.kLeft)< 0.05)
    {
      xSpeedCon = 0.0;
    }
    else{
      xSpeedCon = controller.getX(GenericHID.Hand.kLeft);
    }

    if(controller.getX(GenericHID.Hand.kRight)< 0.05)
    {
      rotation = 0.0;
    }
    else{
      rotation = (controller.getX(GenericHID.Hand.kRight));
    }


    // Get the x speed. We are inverting this because Xbox controllers return
    // negative values when we push forward.
    final var xSpeed =
      -xspeedLimiter.calculate(ySpeedCon)
        * SwerveDrivetrain.kMaxSpeed;

    // Get the y speed or sideways/strafe speed. We are inverting this because
    // we want a positive value when we pull to the left. Xbox controllers
    // return positive values when you pull to the right by default.
    final var ySpeed =
      -yspeedLimiter.calculate(xSpeedCon)
        * SwerveDrivetrain.kMaxSpeed;

    // Get the rate of angular rotation. We are inverting this because we want a
    // positive value when we pull to the left (remember, CCW is positive in
    // mathematics). Xbox controllers return positive values when you pull to
    // the right by default.
    final var rot =
      -rotLimiter.calculate(rotation)
        * SwerveDrivetrain.kMaxAngularSpeed;

    boolean calibrate = controller.getBumper(GenericHID.Hand.kLeft);

    drivetrain.drive(xSpeed, ySpeed, rot, true, calibrate);
    
  }

}
