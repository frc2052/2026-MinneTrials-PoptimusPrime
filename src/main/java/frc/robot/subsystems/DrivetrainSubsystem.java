package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  private final WPI_TalonSRX leftMotorSRX;
  private final WPI_TalonSRX rightMotorSRX;

  private final DifferentialDrive diffDrive;

  public DrivetrainSubsystem() {
    leftMotorSRX = new WPI_TalonSRX(0);
    rightMotorSRX = new WPI_TalonSRX(1);

    diffDrive = new DifferentialDrive(leftMotorSRX, rightMotorSRX);
  }

  public void arcadeDrive(double speed, double rotation) {
    diffDrive.arcadeDrive(speed, rotation);
  }
}
