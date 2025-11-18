// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexerSubsystem extends SubsystemBase {
  private final WPI_TalonSRX indexMotorSRX;

  /** Creates a new IndexerSubsystem. */
  public IndexerSubsystem() {
    indexMotorSRX = new WPI_TalonSRX(Constants.IndexerConstants.INDEXER_MOTOR_ID);
    indexMotorSRX.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stopMotor() {
    indexMotorSRX.set(ControlMode.PercentOutput, 0);
  }
}
