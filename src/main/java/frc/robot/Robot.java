package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Robot extends TimedRobot {
  private final XboxController controller = new XboxController(0);

  private final WPI_VictorSPX motorLF = new WPI_VictorSPX(1);  // LF = Left Front
  private final WPI_VictorSPX motorLB = new WPI_VictorSPX(2);  // LB = Left Back
  private final WPI_VictorSPX motorRF = new WPI_VictorSPX(3);  // RF = Right Front
  private final WPI_VictorSPX motorRB = new WPI_VictorSPX(4);  // RB = Right Back
  
  private final DifferentialDrive drive;


  public Robot() {
    // Reset all motors to factory defaults
    motorLF.configFactoryDefault();
    motorLB.configFactoryDefault();
    motorRF.configFactoryDefault();
    motorRB.configFactoryDefault();
    // Set the back motors to follow the front ones
    motorLB.follow(motorLF);
    motorRB.follow(motorRF);

    // Initiate DifferentialDrive
    drive = new DifferentialDrive(motorLF, motorRF);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(controller.getLeftY(), controller.getRightX());
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
