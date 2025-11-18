// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  public Drivetrain() {}
  private final WPI_TalonSRX rightMotor = new WPI_TalonSRX(0);
  private final WPI_TalonSRX leftMotor = new WPI_TalonSRX(1);


  private final DifferentialDrive m_diffDrive =
      new DifferentialDrive(leftMotor::set, rightMotor::set);

    public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
    }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
  }
}
