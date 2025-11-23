package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.Joystick;

// CTRE
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
// REV
// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.SparkBase.PersistMode;


public class Robot_Complete extends TimedRobot {
  private final XboxController controller = new XboxController(0);
  // private final Joystick controller = new Joystick(0);


  // CTRE
  private final WPI_VictorSPX motorLF = new WPI_VictorSPX(1);  // LF = Left Front
  private final WPI_VictorSPX motorLB = new WPI_VictorSPX(2);  // LB = Left Back
  private final WPI_VictorSPX motorRF = new WPI_VictorSPX(3);  // RF = Right Front
  private final WPI_VictorSPX motorRB = new WPI_VictorSPX(4);  // RB = Right Back
  // REV
  // private final SparkMax motorLF = new SparkMax(1, MotorType.kBrushless);  // LF = Left Front
  // private final SparkMax motorLB = new SparkMax(2, MotorType.kBrushless);  // LB = Left Back
  // private final SparkMax motorRF = new SparkMax(3, MotorType.kBrushless);  // RF = Right Front
  // private final SparkMax motorRB = new SparkMax(4, MotorType.kBrushless);  // RB = Right Back
  // private final SparkMaxConfig defaultConfig = new SparkMaxConfig();
  // private final SparkMaxConfig lbConfig = new SparkMaxConfig();
  // private final SparkMaxConfig rbConfig = new SparkMaxConfig();
  
  private final DifferentialDrive drive;


  public Robot_Complete() {
    // CTRE
    // Reset all motors to factory defaults
    motorLF.configFactoryDefault();
    motorLB.configFactoryDefault();
    motorRF.configFactoryDefault();
    motorRB.configFactoryDefault();
    // Set the back motors to follow the front ones
    motorLB.follow(motorLF);
    motorRB.follow(motorRF);

    // REV
    // // Reset all motors to factory defaults
    // motorLF.configure(defaultConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // motorLB.configure(defaultConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // motorRF.configure(defaultConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // motorRB.configure(defaultConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // // Set the back motors to follow the front ones
    // lbConfig.follow(motorLF);
    // motorLB.configure(lbConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // rbConfig.follow(motorRF);
    // motorRB.configure(rbConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

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
