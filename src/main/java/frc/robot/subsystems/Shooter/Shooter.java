package frc.robot.subsystems.Shooter;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;


public class Shooter extends SubsystemBase {
    private final TalonFX ShooterMotor = new TalonFX(52);


  /** Creates a new ExampleSubsystem. */
  public Shooter() {

    setDefaultCommand(stopShooter().ignoringDisable(true));
    SmartDashboard.putNumber("Shoot Voltage", 3);
    SmartDashboard.setPersistent("Shoot Voltage");
    SmartDashboard.setPersistent("prespin shooter voltage");
    SmartDashboard.putNumber("prespin shooter voltage",3);

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command runShooter() {
    return Commands.run(
        () -> ShooterMotor.setVoltage(SmartDashboard.getNumber("Shoot Voltage", 3)),

        this
    );
  }

  public Command stopShooter(){
    return Commands.run(
    () -> ShooterMotor.setVoltage(0),

    this
    );
    
  }
  
  public Command spinupShooter(){
    return runShooter()
    .withTimeout(1);
  }


  public Command preSpinupShooter(){
    return Commands.run(
      ()-> ShooterMotor.setVoltage(SmartDashboard.getNumber("prespin shooter voltage",4)),

      this
    );
  }




  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Voltage", ShooterMotor.getMotorVoltage().getValueAsDouble());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}

